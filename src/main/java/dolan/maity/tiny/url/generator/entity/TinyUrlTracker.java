package dolan.maity.tiny.url.generator.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tiny_url_tracker")
@NoArgsConstructor
@Getter
@Setter
public class TinyUrlTracker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tiny_url_id", nullable = false)
    private TinyUrlEntity tinyUrlEntity;
    // Stored as Long datatype for date time for faster query in database
    private Long hitTime;
}
