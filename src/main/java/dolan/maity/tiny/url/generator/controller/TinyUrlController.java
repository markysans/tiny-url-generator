package dolan.maity.tiny.url.generator.controller;

import dolan.maity.tiny.url.generator.models.response.Response;
import dolan.maity.tiny.url.generator.models.response.TinyUrlResponse;
import dolan.maity.tiny.url.generator.service.TinyUrlService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TinyUrlController {
    private final TinyUrlService tinyUrlService;
    @PostMapping("/v1/create")
    public ResponseEntity<Response<Object>> generateTinyUrl(@RequestParam String originalUrl) {
        TinyUrlResponse response = tinyUrlService.getTinyUrlGenerated(originalUrl);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                Response.builder()
                        .message("Created Successfully")
                        .responseDate(response)
                        .build()
        );
    }
}
