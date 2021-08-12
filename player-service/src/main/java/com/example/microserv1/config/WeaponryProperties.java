package com.example.microserv1.config;

import com.example.microserv1.config.AbstractPropertiesPlaceHolder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ToString(callSuper = true)
@ConfigurationProperties(prefix = "weaponry.api")
public class WeaponryProperties extends AbstractPropertiesPlaceHolder {


}
