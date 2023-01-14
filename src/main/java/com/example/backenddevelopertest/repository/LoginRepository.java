package com.example.backenddevelopertest.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.backenddevelopertest.model.LoginModel;

@Repository
public interface LoginRepository extends JpaRepository<LoginModel, Long>{
	@Query(value = "SELECT * FROM Users WHERE username  = ?1 and password_hash = ?2", nativeQuery = true)
	Optional<LoginModel> doLogin(String username, String password);
	
	@Query(value = "SELECT * FROM Users WHERE acces_token = ?1", nativeQuery = true)
	Optional<LoginModel> findByAccesToken(String token);

}
