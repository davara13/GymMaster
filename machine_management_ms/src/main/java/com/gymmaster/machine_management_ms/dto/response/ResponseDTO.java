package com.gymmaster.machine_management_ms.dto.response;

import org.springframework.http.HttpStatusCode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDTO {
    private String message;
    private HttpStatusCode statusCode;
}
