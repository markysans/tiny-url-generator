package dolan.maity.tiny.url.generator.service.service;

import dolan.maity.tiny.url.generator.entity.TinyUrlEntity;
import dolan.maity.tiny.url.generator.entity.TinyUrlTracker;
import dolan.maity.tiny.url.generator.respository.TinyUrlTrackerRepository;
import dolan.maity.tiny.url.generator.service.TinyUrlTrackerService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@RequiredArgsConstructor
public class TinyUrlTrackerServiceImpl implements TinyUrlTrackerService {
    private final TinyUrlTrackerRepository trackerRepository;
    @Async
    @Override
    public void trackHits(TinyUrlEntity tinyUrl) {
        TinyUrlTracker tracker = new TinyUrlTracker();
        tracker.setTinyUrl(tinyUrl);
        tracker.setHitTime(Instant.now().getEpochSecond());
        trackerRepository.save(tracker);
    }
}
