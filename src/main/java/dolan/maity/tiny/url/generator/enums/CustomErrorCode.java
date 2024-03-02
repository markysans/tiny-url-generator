package dolan.maity.tiny.url.generator.enums;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum CustomErrorCode {
    INTERNAL_ERROR("TUG_001", "Some Technical Error!", HttpStatus.INTERNAL_SERVER_ERROR),
    ALREADY_EXIST_ERROR("TUG_002", "Tiny Url Already Exist!", HttpStatus.CONFLICT),
    NOT_FOUND_ERROR("TUG_003", "Tiny Url Does Not Exist!", HttpStatus.NOT_FOUND)
    ;
    private final String code;
    private final String message;
    private final HttpStatus httpStatus;
    CustomErrorCode(String code, String message, HttpStatus httpStatus) {
        this.code = code;
        this.message = message;
        this.httpStatus = httpStatus;
    }
}
