package dolan.maity.tiny.url.generator.respository;

import dolan.maity.tiny.url.generator.entity.TinyUrlEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TinyUrlRepository extends JpaRepository<TinyUrlEntity, Long> {
    boolean existsByTinyUrl(String alphaNumericString);

    boolean existsByOriginalUrl(String originalUrl);
}
