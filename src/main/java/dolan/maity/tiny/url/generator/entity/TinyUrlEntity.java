package dolan.maity.tiny.url.generator.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tiny_url")
@NoArgsConstructor
@Getter
public class TinyUrlEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String originalUrl;
    private String shortenUrl;
    private Boolean isActive;
}
