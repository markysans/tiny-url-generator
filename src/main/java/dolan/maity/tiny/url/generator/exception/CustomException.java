package dolan.maity.tiny.url.generator.exception;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dolan.maity.tiny.url.generator.enums.CustomErrorCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
public class CustomException extends RuntimeException{
    private final String errorCode;
    private final String errorMessage;
    private final HttpStatus httpStatus;
    public CustomException(CustomErrorCode customErrorCode) {
        this.errorCode = customErrorCode.getCode();
        this.errorMessage = customErrorCode.getMessage();
        this.httpStatus = customErrorCode.getHttpStatus();
    }
}
