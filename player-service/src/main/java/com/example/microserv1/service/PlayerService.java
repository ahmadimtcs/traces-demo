package com.example.microserv1.service;

import com.example.microserv1.dto.PlayerRequest;
import com.example.microserv1.dto.PlayerResponse;
import lombok.NonNull;

public interface PlayerService {

   PlayerResponse createPlayer(@NonNull final PlayerRequest playerRequest);
}
