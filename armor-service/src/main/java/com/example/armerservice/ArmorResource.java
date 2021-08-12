package com.example.armerservice;

import java.util.Arrays;
import java.util.List;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = ArmorResource.BASE_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class ArmorResource {


  static final String BASE_URL = "/api/v1/armors";

  @GetMapping
  public ResponseEntity<List<String>> getArmors() {
    return ResponseEntity.ok(
        Arrays.asList("Gambeson", "Boiled leather", "Shell armor", "Scale armor", "Mail armor"));
  }
}
