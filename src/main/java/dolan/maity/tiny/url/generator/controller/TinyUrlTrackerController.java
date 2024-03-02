package dolan.maity.tiny.url.generator.controller;

import dolan.maity.tiny.url.generator.enums.TrackingParameter;
import dolan.maity.tiny.url.generator.models.response.Response;
import dolan.maity.tiny.url.generator.models.response.TrackingResponse;
import dolan.maity.tiny.url.generator.service.TinyUrlTrackerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
public class TinyUrlTrackerController {
    private final TinyUrlTrackerService tinyUrlTrackerService;
    @GetMapping("/v1/track")
    public ResponseEntity<Response<Object>> trackingDetails(@RequestParam TrackingParameter trackingParameter,
                                                            @RequestParam String url,
                                                            @RequestParam(required = false) LocalDateTime startTime,
                                                            @RequestParam(required = false) LocalDateTime endTime) {
        TrackingResponse response = tinyUrlTrackerService.trackingDetails(trackingParameter, url, startTime, endTime);
        return ResponseEntity.ok(
                Response.builder()
                        .message("Tracking details fetched!")
                        .responseDate(response)
                        .build()
        );
    }
}
