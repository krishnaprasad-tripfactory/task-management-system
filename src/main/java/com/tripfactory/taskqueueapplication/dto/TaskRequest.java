package com.tripfactory.taskqueueapplication.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class TaskRequest {
    private String id;
    private String task;
    private Map<String, Object> taskParams;
    private int time;
}
