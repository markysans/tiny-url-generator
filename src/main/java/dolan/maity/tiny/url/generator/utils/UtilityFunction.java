package dolan.maity.tiny.url.generator.utils;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class UtilityFunction {
    private static final ZoneId ZONE_ID = ZoneId.systemDefault();
    public static LocalDateTime getLocalDateTimeFromLocale(Long locale) {
        Instant epochSecond = Instant.ofEpochSecond(locale);
        return epochSecond.atZone(ZONE_ID).toLocalDateTime();
    }

    public static Long getLongFromDateTime(LocalDateTime dateTime) {
        return dateTime.atZone(ZONE_ID).toEpochSecond();
    }
}
