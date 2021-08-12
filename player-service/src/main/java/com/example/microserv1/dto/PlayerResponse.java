package com.example.microserv1.dto;

import java.util.Map;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@ToString
@SuperBuilder
public class PlayerResponse extends AbstractPlayer {

  private Map<String, Object> armors;

  private Map<String, Object> weaponry;
}
