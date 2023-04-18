package br.com.onebox.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication
@EnableSpringDataWebSupport
public class ComexApplication {
    public static void main(String[] args) {
        SpringApplication.run(ComexApplication.class, args);

    }
}
