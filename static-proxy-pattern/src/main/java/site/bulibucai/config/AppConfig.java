package site.bulibucai.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import site.bulibucai.MarkClass;

@Configuration
@ComponentScan(basePackageClasses = MarkClass.class)
public class AppConfig {
}
