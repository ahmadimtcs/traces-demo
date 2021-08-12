package com.example.microserv1.persistence.domain;

import java.util.HashMap;
import java.util.Map;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@ToString
@Builder
public class Player {

  @Id
  private String id;

  private String firstName;

  private String lastName;

  private Map<String, Object> armors;

  private Map<String, Object> weaponry;
}
