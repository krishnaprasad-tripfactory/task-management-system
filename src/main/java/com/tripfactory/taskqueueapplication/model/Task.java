package com.tripfactory.taskqueueapplication.model;

import lombok.Data;

import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicReference;

@Data
public class Task {
    private final String id;
    private final int time;
    private final String name;
    private final Map<String, Object> taskParams;
    private AtomicReference<TaskStatus> status = new AtomicReference<>(TaskStatus.QUEUED);
    private CompletableFuture<TaskStatus> result = new CompletableFuture<>();
    private volatile Future<?> future;
}
