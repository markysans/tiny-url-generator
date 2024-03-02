package dolan.maity.tiny.url.generator.models.response;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@Getter
public class TrackingResponse {
    private Long count;
    private String originalUrl;
    private String tinyUrl;
    private List<LocalDateTime> hitTimeList;
}
