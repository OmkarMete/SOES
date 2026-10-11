
package com.jsp.soes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.jsp")
@org.springframework.boot.persistence.autoconfigure.EntityScan (basePackages = "com.jsp.entity")
@EnableJpaRepositories(basePackages = "com.jsp.dao")
public class SoesApplication {

    public static void main(String[] args) {
        SpringApplication.run(SoesApplication.class, args);
    }

}
