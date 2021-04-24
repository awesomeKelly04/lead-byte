package com.byteworks.leadbyte;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

@SpringBootApplication
@EntityScan(basePackageClasses = {
        LeadByteApplication.class,
        Jsr310JpaConverters.class
})
public class LeadByteApplication {

    public static void main(String[] args) {
        SpringApplication.run(LeadByteApplication.class, args);
    }

}
