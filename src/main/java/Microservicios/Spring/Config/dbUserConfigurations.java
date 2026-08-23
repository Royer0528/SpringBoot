package Microservicios.Spring.Config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "db")

public class dbUserConfigurations {
    private String userName;
    private String password;

    @Override
    public String toString() {
        return "dbUserConfigurations: " + "/n" +
                "userName=" + this.userName + "/n" +
                "password=" + this.password;
    }
}
