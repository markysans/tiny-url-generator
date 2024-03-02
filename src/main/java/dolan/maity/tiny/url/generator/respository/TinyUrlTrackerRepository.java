package dolan.maity.tiny.url.generator.respository;

import dolan.maity.tiny.url.generator.entity.TinyUrlTracker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TinyUrlTrackerRepository extends JpaRepository<TinyUrlTracker, Long> {
    @Query("select tut from TinyUrlTracker tut where tut.tinyUrlEntity.tinyUrl = :url")
    List<TinyUrlTracker> getAllByTinyUrl(@Param("url")String url);
    @Query("select tut from TinyUrlTracker tut where tut.tinyUrlEntity.originalUrl = :url")
    List<TinyUrlTracker> getAllByOriginalUrl(String url);
    @Query("select tut from TinyUrlTracker tut where tut.tinyUrlEntity.tinyUrl = :url "
    + "AND tut.hitTime >= :start")
    List<TinyUrlTracker> getAllByTinyUrlAndAfter(@Param("url")String url, @Param("start")Long start);
    @Query("select tut from TinyUrlTracker tut where tut.tinyUrlEntity.originalUrl = :url "
            + "AND tut.hitTime >= :start")
    List<TinyUrlTracker> getAllByOriginalUrlAndAfter(@Param("url")String url, @Param("start")Long start);
    @Query("select tut from TinyUrlTracker tut where tut.tinyUrlEntity.tinyUrl = :url "
            + "AND tut.hitTime between :start and :end")
    List<TinyUrlTracker> getAllByTinyUrlAndBetween(@Param("url")String url, @Param("start")Long start, @Param("end")Long end);
    @Query("select tut from TinyUrlTracker tut where tut.tinyUrlEntity.originalUrl = :url "
            + "AND tut.hitTime between :start and :end")
    List<TinyUrlTracker> getAllByOriginalUrlAndBetween(@Param("url")String url, @Param("start")Long start, @Param("end")Long end);
}
