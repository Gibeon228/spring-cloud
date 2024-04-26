package ru;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.timer.TimerAspect;

@Configuration
public class TimerAutoConfiguration {

    @Bean
    TimerAspect timer() {
        return new TimerAspect();
    }
}
