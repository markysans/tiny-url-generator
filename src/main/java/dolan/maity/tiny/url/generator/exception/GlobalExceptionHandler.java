package dolan.maity.tiny.url.generator.exception;

import dolan.maity.tiny.url.generator.models.response.ErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ErrorResponse> handleCustomException(CustomException exception) {
        return ResponseEntity.status(exception.getHttpStatus().value())
                .body(new ErrorResponse(exception));
    }
}
