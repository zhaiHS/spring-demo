package ioc.annotation.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan("ioc.annotation")
@Import({DataSourcConfiguration.class})
public class SpringConfiguration {
}
