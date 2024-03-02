package dolan.maity.tiny.url.generator.service;

import dolan.maity.tiny.url.generator.entity.TinyUrlEntity;
import org.springframework.scheduling.annotation.Async;

public interface TinyUrlTrackerService {
    @Async
    void trackHits(TinyUrlEntity tinyUrl);
}
