package dolan.maity.tiny.url.generator.service;

import dolan.maity.tiny.url.generator.models.response.TinyUrlResponse;

public interface TinyUrlService {
    TinyUrlResponse getTinyUrlGenerated(String originalUrl);

    TinyUrlResponse fetchTinyUrl(String originalUrl);

    String redirectByTinyUrl(String tinyUrl);
}
