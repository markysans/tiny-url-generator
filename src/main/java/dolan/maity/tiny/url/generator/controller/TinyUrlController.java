package dolan.maity.tiny.url.generator.controller;

import dolan.maity.tiny.url.generator.models.response.Response;
import dolan.maity.tiny.url.generator.models.response.TinyUrlResponse;
import dolan.maity.tiny.url.generator.service.TinyUrlService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

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

    @GetMapping("/v1/fetch")
    public ResponseEntity<Response<Object>> fetchTinyUrl(@RequestParam String originalUrl) {
        TinyUrlResponse response = tinyUrlService.fetchTinyUrl(originalUrl);
        return ResponseEntity.status(HttpStatus.FOUND).body(
                Response.builder()
                        .message("Fetched Successfully")
                        .responseDate(response)
                        .build()
        );
    }

    @GetMapping("/{tinyUrl}")
    public RedirectView redirect(@PathVariable String tinyUrl) {
        String redirectUrl = tinyUrlService.redirectByTinyUrl(tinyUrl);
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl(redirectUrl);
        return redirectView;
    }
}
