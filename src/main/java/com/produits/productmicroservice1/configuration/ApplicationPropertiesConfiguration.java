package com.produits.productmicroservice1.configuration;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("mes-configs")
@RefreshScope
@Data
public class ApplicationPropertiesConfiguration {

    private int limitDeProduit;
}
