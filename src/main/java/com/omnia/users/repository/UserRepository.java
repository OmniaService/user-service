package com.omnia.users.repository;

import com.omnia.users.model.entities.UserEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends BaseRepository<UserEntity, Long> {
}
