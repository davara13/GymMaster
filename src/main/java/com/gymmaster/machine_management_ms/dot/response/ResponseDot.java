package com.gymmaster.machine_management_ms.dot.response;

import org.springframework.http.HttpStatusCode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDot {
    private String message;
    private HttpStatusCode statusCode;
}
