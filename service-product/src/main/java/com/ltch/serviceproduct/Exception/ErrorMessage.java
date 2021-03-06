package com.ltch.serviceproduct.Exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class ErrorMessage {
    private Integer statusCode;
    private String message;
    private String description;
    private Date timestamp;
}
