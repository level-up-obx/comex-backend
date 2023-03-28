package br.com.onebox.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@ComponentScan(basePackages = "br.com.onebox.app.repositories")
@RestController
public class ApiApp {

    public static void main(String[] args) {
        SpringApplication.run(ApiApp.class, args);
    }

}
