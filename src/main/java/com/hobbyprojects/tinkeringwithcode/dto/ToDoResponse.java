package com.hobbyprojects.tinkeringwithcode.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ToDoResponse {
    private String code;
    private String message;
}
