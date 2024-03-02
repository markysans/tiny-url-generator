package dolan.maity.tiny.url.generator.service.service;

import dolan.maity.tiny.url.generator.entity.TinyUrlEntity;
import dolan.maity.tiny.url.generator.enums.CustomErrorCode;
import dolan.maity.tiny.url.generator.exception.CustomException;
import dolan.maity.tiny.url.generator.models.response.TinyUrlResponse;
import dolan.maity.tiny.url.generator.respository.TinyUrlRepository;
import dolan.maity.tiny.url.generator.service.TinyUrlService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class TinyUrlServiceImpl implements TinyUrlService {
    private final TinyUrlRepository tinyUrlRepository;
    @Value("${tiny.url.alphanumeric.length}")
    private int alphanumericLength;
    @Value("${tiny.url.base.path}")
    private String tinyBaseUrl;
    @Override
    public TinyUrlResponse getTinyUrlGenerated(String originalUrl) {
        if(tinyUrlRepository.existsByOriginalUrl(originalUrl)) {
            throw new CustomException(CustomErrorCode.ALREADY_EXIST_ERROR);
        }
        String tinyUrl = generateAlphanumericUniqueUrl();
        TinyUrlEntity entity = new TinyUrlEntity();
        entity.setOriginalUrl(originalUrl);
        entity.setTinyUrl(tinyUrl);
        entity.setIsActive(true);
        tinyUrlRepository.save(entity);
        return mapToTinyUrlGeneratedResponse(entity);
    }

    @Override
    public TinyUrlResponse fetchTinyUrl(String originalUrl) {
        TinyUrlEntity tinyUrlEntity = tinyUrlRepository.findByOriginalUrl(originalUrl)
                .orElseThrow(() -> new CustomException(CustomErrorCode.NOT_FOUND_ERROR));
        return mapToTinyUrlGeneratedResponse(tinyUrlEntity);
    }
    @Override
    public String redirectByTinyUrl(String tinyUrl) {
        TinyUrlEntity tinyUrlEntity = tinyUrlRepository.findByTinyUrl(tinyUrl)
                .orElseThrow(() -> new CustomException(CustomErrorCode.NOT_FOUND_ERROR));
        return tinyUrlEntity.getOriginalUrl();
    }

    private TinyUrlResponse mapToTinyUrlGeneratedResponse(TinyUrlEntity entity) {
        return TinyUrlResponse.builder()
                .originalUrl(entity.getOriginalUrl())
                .tinyUrl(tinyBaseUrl + entity.getTinyUrl())
                .isActive(entity.getIsActive())
                .build();
    }

    private String generateAlphanumericUniqueUrl(){
        while(true) {
            String alphaNumericString = RandomStringUtils.randomAlphanumeric(alphanumericLength);
            if(!tinyUrlRepository.existsByTinyUrl(alphaNumericString))
                return alphaNumericString;
        }
    }
}
