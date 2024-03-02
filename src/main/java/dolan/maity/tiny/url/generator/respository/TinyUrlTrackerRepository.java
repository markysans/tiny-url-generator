package dolan.maity.tiny.url.generator.respository;

import dolan.maity.tiny.url.generator.entity.TinyUrlTracker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TinyUrlTrackerRepository extends JpaRepository<TinyUrlTracker, Long> {
}
