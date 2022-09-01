package br.com.fiap.epictaskapi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.epictaskapi.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
 
    Optional<User> findByEmail(String email);

}
