package dolan.maity.tiny.url.generator.service;

import dolan.maity.tiny.url.generator.entity.TinyUrlEntity;
import dolan.maity.tiny.url.generator.enums.TrackingParameter;
import dolan.maity.tiny.url.generator.models.response.TrackingResponse;
import org.springframework.scheduling.annotation.Async;

import java.time.LocalDateTime;

public interface TinyUrlTrackerService {
    @Async
    void trackHits(TinyUrlEntity tinyUrl);

    TrackingResponse trackingDetails(TrackingParameter parameter, String url, LocalDateTime startTime, LocalDateTime endTime);
}
