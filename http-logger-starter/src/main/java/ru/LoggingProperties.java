package ru;

import lombok.Data;
import org.slf4j.event.Level;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties("http.logging")
public class LoggingProperties {

    /**
     * Включить\выключить логирование тела запроса
     */
    private boolean logBody = false;

    /**
     * Уровень логирования
     */
    private Level logLevel = Level.DEBUG;
}
