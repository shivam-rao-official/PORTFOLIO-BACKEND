package com.majorproject.PortfolioMaker.models;

import lombok.*;
import org.springframework.http.HttpStatus;

import java.util.Date;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SuccessResponse {

    private String msg;
    private HttpStatus httpStatus;
    private int httpCode;
    private Object data;
    private Date timeStamp;
}
