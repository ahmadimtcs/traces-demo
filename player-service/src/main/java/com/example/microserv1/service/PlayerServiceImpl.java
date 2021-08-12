package com.example.microserv1.service;

import com.example.microserv1.config.ArmorProperties;
import com.example.microserv1.config.WeaponryProperties;
import com.example.microserv1.persistence.domain.Player;
import com.example.microserv1.persistence.repo.PlayerRepo;
import com.example.microserv1.dto.PlayerRequest;
import com.example.microserv1.dto.PlayerResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import lombok.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

@Service
public class PlayerServiceImpl implements PlayerService {

  private final PlayerRepo playerRepo;
  private final ArmorProperties armorProperties;
  private final WeaponryProperties weaponryProperties;
  private final RestTemplate restTemplate;

  public PlayerServiceImpl(PlayerRepo playerRepo, ArmorProperties armorProperties,
      WeaponryProperties weaponryProperties,
      RestTemplate restTemplate) {
    this.playerRepo = playerRepo;
    this.armorProperties = armorProperties;
    this.weaponryProperties = weaponryProperties;
    this.restTemplate = restTemplate;
  }

  @Override
  public PlayerResponse createPlayer(@NonNull PlayerRequest playerRequest) {
    Player player = Player.builder()
        .id(UUID.randomUUID().toString())
        .firstName(playerRequest.getFirstName())
        .lastName(playerRequest.getLastName())
        .build();
    Object armors = restTemplate.getForObject(armorProperties.getUrl(), Object.class);
    final var playerArmors = player.getArmors();
    if (CollectionUtils.isEmpty(playerArmors)) {
      final var armors1 = new HashMap<String, Object>();
      armors1.put("armors", armors);
      player.setArmors(armors1);
    } else {
      playerArmors.put("armors", armors);
    }

    final var weapons = restTemplate.getForObject(weaponryProperties.getUrl(), Object.class);
    final var playerWeaponry = player.getWeaponry();
    if (CollectionUtils.isEmpty(playerWeaponry)) {
      final var weapons1 = new HashMap<String, Object>();
      weapons1.put("weapons", weapons);
      player.setWeaponry(weapons1);
    } else {
      playerWeaponry.put("weapons", weapons);
    }

    final var savedPlayer = playerRepo.save(player);
    return PlayerResponse.builder()
        .firstName(savedPlayer.getFirstName())
        .lastName(savedPlayer.getLastName())
        .armors(savedPlayer.getArmors())
        .weaponry(savedPlayer.getWeaponry())
        .build();
  }
}
