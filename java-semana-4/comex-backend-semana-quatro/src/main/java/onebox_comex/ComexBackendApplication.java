package onebox_comex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("onebox_comex.repository")
public class ComexBackendApplication {
    public static void main(String[] args) {
        SpringApplication.run(ComexBackendApplication.class, args);
    }
}
