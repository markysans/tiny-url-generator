package dolan.maity.tiny.url.generator.models.response;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Response<T> {
    private String message;
    private T responseDate;
}
