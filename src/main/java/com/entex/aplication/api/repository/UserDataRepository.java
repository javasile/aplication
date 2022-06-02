package com.entex.aplication.api.repository;

import com.entex.aplication.api.model.UserData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDataRepository extends JpaRepository<UserData, Integer> {
    boolean existsUserDataByEmail(String email);
}
