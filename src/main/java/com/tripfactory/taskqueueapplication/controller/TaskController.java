package com.tripfactory.taskqueueapplication.controller;

import com.tripfactory.taskqueueapplication.dto.IdRequest;
import com.tripfactory.taskqueueapplication.dto.TaskRequest;
import com.tripfactory.taskqueueapplication.model.TaskStatus;
import com.tripfactory.taskqueueapplication.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequiredArgsConstructor
public class TaskController {
    private final TaskService taskService;

    @PostMapping("/queueTask")
    public Map<String, Object> queueTask(@RequestBody TaskRequest request) throws Exception {

        TaskStatus status = taskService.queueTask(request.getId(), request.getTime(), request.getTask(), request.getTaskParams());
        return Map.of(
                "id", request.getId(),
                "status", status
        );
    }

    @PostMapping("/checkStatus")
    public Map<String, Object> checkStatus(@RequestBody IdRequest request) {

        TaskStatus status = taskService.checkStatus(request.getId());
        return Map.of(
                "id", request.getId(),
                "status", status
        );
    }

    @PostMapping("/stopTask")
    public Map<String, Object> stopTask(@RequestBody IdRequest request) {

        TaskStatus status = taskService.stopTask(request.getId());
        return Map.of(
                "id", request.getId(),
                "status", status
        );}

}
