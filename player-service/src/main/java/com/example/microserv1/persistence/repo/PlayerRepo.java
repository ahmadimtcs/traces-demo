package com.example.microserv1.persistence.repo;

import com.example.microserv1.persistence.domain.Player;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PlayerRepo extends MongoRepository<Player, String> {

}
