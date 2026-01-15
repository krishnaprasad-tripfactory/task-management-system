package com.tripfactory.taskqueueapplication.service;


import ch.qos.logback.core.net.SyslogOutputStream;
import com.tripfactory.taskqueueapplication.model.Task;
import com.tripfactory.taskqueueapplication.model.TaskStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final ThreadPoolExecutor taskExecutor;
    private final Map<String, Task> taskMap = new ConcurrentHashMap<>();

    public TaskStatus queueTask(String id, int time, String name, Map<String, Object> taskParams) throws Exception{
        Task task = new Task(id, time, name, taskParams);
        if (taskMap.putIfAbsent(id, task) != null) {
            System.out.println("Duplicate Task");
            return TaskStatus.DUPLICATE;
        }
        Future<?> future =  taskExecutor.submit(() -> executeTask(task));
        task.setFuture(future);
        return task.getResult().get();
    }

    private void executeTask(Task task) {
        boolean canRun = task.getStatus().compareAndSet(TaskStatus.QUEUED, TaskStatus.RUNNING);
        if (!canRun) {
            return;
        }
        try {

            Thread.sleep(task.getTime() * 1000L);
            task.getStatus().set(TaskStatus.DONE);
            task.getResult().complete(TaskStatus.DONE);

        } catch (InterruptedException e) {

            task.getStatus().set(TaskStatus.STOPPED);
            task.getResult().complete(TaskStatus.STOPPED);
            Thread.currentThread().interrupt();
        } finally {
            taskMap.remove(task.getId());
        }
    }

    public TaskStatus checkStatus(String id) {
        Task task = taskMap.get(id);
        if (task == null) {
            return TaskStatus.DONE;
        }
        return task.getStatus().get();
    }

    public TaskStatus stopTask(String id) {

        Task task = taskMap.get(id);
        if (task == null) return TaskStatus.DONE;
        TaskStatus currentStatus = task.getStatus().get();
        if (currentStatus == TaskStatus.QUEUED) {
            task.getFuture().cancel(false);
            task.getStatus().set(TaskStatus.STOPPED);
            task.getResult().complete(TaskStatus.STOPPED);
            taskMap.remove(id);
        }
        if (currentStatus == TaskStatus.RUNNING) {
            task.getFuture().cancel(true);
        }

        return TaskStatus.STOPPED;
    }
}
