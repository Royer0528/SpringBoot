package com.Practica.Propuesta1.Spring.Config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;


@Getter@Setter
@Configuration
@ConfigurationProperties(prefix = "db")

public class dbUserConfigurations {
    private String userName;
    private String password;

    @Override
    public String toString() {
        return "dbUserConfigurations: " + "\n" +
                "userName=" + this.userName + "\n" +
                "password=" + this.password;
    }
}
