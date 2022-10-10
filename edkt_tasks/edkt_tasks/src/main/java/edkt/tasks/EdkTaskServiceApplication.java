package edkt.tasks;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableScheduling
public class EdkTaskServiceApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(EdkTaskServiceApplication.class).web(WebApplicationType.REACTIVE).run(args);
//        SpringApplication.run(EdkTaskServiceApplication.class, args);
    }
}
