package com.example.microserv1;

import com.example.microserv1.config.ArmorProperties;
import com.example.microserv1.config.WeaponryProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@ConfigurationPropertiesScan(basePackageClasses = ArmorProperties.class)
@EnableConfigurationProperties
@Slf4j
public class PlayerApplication implements CommandLineRunner {

  @Autowired
  private ArmorProperties armorProperties;

  @Autowired
  private WeaponryProperties weaponryProperties;

  public static void main(String[] args) {
    SpringApplication.run(PlayerApplication.class, args);
  }

  @Bean
  public RestTemplate restTemplate() {
    return new RestTemplate();
  }

  /**
   * Callback used to run the bean.
   *
   * @param args incoming main method arguments
   * @throws Exception on error
   */
  @Override
  public void run(String... args) throws Exception {
    log.info("Armor Properties {}", armorProperties);
    log.info("Weapon Properties {}", weaponryProperties);
  }
}
