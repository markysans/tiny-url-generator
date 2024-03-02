package dolan.maity.tiny.url.generator.service.service;

import dolan.maity.tiny.url.generator.entity.TinyUrlEntity;
import dolan.maity.tiny.url.generator.entity.TinyUrlTracker;
import dolan.maity.tiny.url.generator.enums.CustomErrorCode;
import dolan.maity.tiny.url.generator.enums.TrackingParameter;
import dolan.maity.tiny.url.generator.exception.CustomException;
import dolan.maity.tiny.url.generator.models.response.TrackingResponse;
import dolan.maity.tiny.url.generator.respository.TinyUrlRepository;
import dolan.maity.tiny.url.generator.respository.TinyUrlTrackerRepository;
import dolan.maity.tiny.url.generator.service.TinyUrlTrackerService;
import dolan.maity.tiny.url.generator.utils.UtilityFunction;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TinyUrlTrackerServiceImpl implements TinyUrlTrackerService {
    private final TinyUrlRepository tinyUrlRepository;
    private final TinyUrlTrackerRepository trackerRepository;
    @Value("${tiny.url.base.path}")
    private String tinyBaseUrl;
    @Async
    @Override
    public void trackHits(TinyUrlEntity tinyUrl) {
        TinyUrlTracker tracker = new TinyUrlTracker();
        tracker.setTinyUrlEntity(tinyUrl);
        tracker.setHitTime(Instant.now().getEpochSecond());
        trackerRepository.save(tracker);
    }

    @Override
    public TrackingResponse trackingDetails(TrackingParameter parameter, String url, LocalDateTime startTime, LocalDateTime endTime) {
        url = parameter == TrackingParameter.TINY_URL ? url.substring(tinyBaseUrl.length()) : url;

        TinyUrlEntity tinyUrlEntity = (parameter == TrackingParameter.TINY_URL
                ? tinyUrlRepository.findByTinyUrl(url)
                : tinyUrlRepository.findByOriginalUrl(url)).orElseThrow(
                () -> new CustomException(CustomErrorCode.NOT_FOUND_ERROR)
        );
        List<TinyUrlTracker> trackerList = getTrackingList(parameter, url, startTime, endTime);
        if(trackerList.isEmpty()) {
            return TrackingResponse.builder()
                    .count(0L)
                    .originalUrl(tinyUrlEntity.getOriginalUrl())
                    .tinyUrl(tinyBaseUrl + tinyUrlEntity.getTinyUrl())
                    .build();
        }

        return TrackingResponse.builder()
                .count((long) trackerList.size())
                .originalUrl(tinyUrlEntity.getOriginalUrl())
                .tinyUrl(tinyBaseUrl + tinyUrlEntity.getTinyUrl())
                .hitTimeList(trackerList.stream().map(TinyUrlTracker::getHitTime).map(UtilityFunction::getLocalDateTimeFromLocale).toList())
                .build();

    }

    private List<TinyUrlTracker> getTrackingList(TrackingParameter parameter, String url, LocalDateTime startTime, LocalDateTime endTime) {
        if(startTime != null && endTime != null) {
            Long start = UtilityFunction.getLongFromDateTime(startTime);
            Long end = UtilityFunction.getLongFromDateTime(endTime);
            if(parameter == TrackingParameter.TINY_URL)
                return trackerRepository.getAllByTinyUrlAndBetween(url, start, end);
            return trackerRepository.getAllByOriginalUrlAndBetween(url, start, end);
        } else if (startTime != null) {
            Long start = UtilityFunction.getLongFromDateTime(startTime);
            if(parameter == TrackingParameter.TINY_URL)
                return trackerRepository.getAllByTinyUrlAndAfter(url, start);
            return trackerRepository.getAllByOriginalUrlAndAfter(url, start);
        } else {
            if(parameter == TrackingParameter.TINY_URL)
                return trackerRepository.getAllByTinyUrl(url);
            return trackerRepository.getAllByOriginalUrl(url);
        }
    }
}
