package com.sumauma.springComMySQL.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sumauma.springComMySQL.entities.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
