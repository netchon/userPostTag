package cv.zing.interview.exceptions;

import cv.zing.interview.utilities.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Collections;

@ControllerAdvice
public class GlobalException extends ResponseEntityExceptionHandler {
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleUserNotFoundException
            (Exception ex, WebRequest request) {

        ApiResponse error =  new ApiResponse.Builder()
                .withStatus(false)
                .withStatusText("RECORD_NOT_FOUND")
                .withDetails(Collections.singletonList(ex.getMessage())).build();
        return new ResponseEntity<Object>(error , HttpStatus.NOT_FOUND);
    }
}
