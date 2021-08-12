package com.example.weaponryservice;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = WeaponResource.BASE_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class WeaponResource {

  static final String BASE_URL = "/api/v1/weapons";

  @GetMapping
  public ResponseEntity<List<String>> getWeapons() {
    final var nextInt = ThreadLocalRandom.current().nextInt(1, 10);

    if (nextInt % 2 == 0) {
      return ResponseEntity.badRequest().body(null);
    }
    return ResponseEntity.ok(
        Arrays.asList("Hydra", "Sniper Rifle", "Plasma Grenade", "Hunter Arm Turret"));
  }
}
