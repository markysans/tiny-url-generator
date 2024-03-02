package dolan.maity.tiny.url.generator.models.response;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class TinyUrlResponse {
    private String originalUrl;
    private String tinyUrl;
    private Boolean isActive;
}
