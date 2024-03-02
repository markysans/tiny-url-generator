package dolan.maity.tiny.url.generator.models.response;

import dolan.maity.tiny.url.generator.exception.CustomException;
import lombok.Getter;

@Getter
public class ErrorResponse {
    private final String errorCode;
    private final String errorMessage;
    public ErrorResponse(CustomException exception) {
        this.errorCode = exception.getErrorCode();
        this.errorMessage = exception.getErrorMessage();
    }
}
