package com.Practica.Propuesta1.Spring.Config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;


@Getter@Setter
@Configuration
@ConfigurationProperties(prefix = "app")
public class ExternalizedConfigurations {

    private String name;
    private String version;
    private String autor;
    private String language;
    private String country;

    @Override
    public String toString() {
        return "ExternalizedConfigurations: " + "\n" +
                "nombre=" + this.name + "\n" +
                "version=" + this.version + "\n" +
                "autor=" + this.autor + "\n" +
                "language=" + this.language + "\n" +
                "country=" + this.country
        ;
    }
}
