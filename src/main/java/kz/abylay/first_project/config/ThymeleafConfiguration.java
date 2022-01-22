package kz.abylay.first_project.config;

import nz.net.ultraq.thymeleaf.LayoutDialect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ThymeleafConfiguration {
    /*@Bean
    public SpringTemplateEngine thymeleafLayoutDialect(){
        SpringTemplateEngine engine = new SpringTemplateEngine();
        engine.addDialect(new LayoutDialect());
        return engine;
    }*/
    @Bean
    public LayoutDialect layoutDialect() {
        return new LayoutDialect();
    }
}
