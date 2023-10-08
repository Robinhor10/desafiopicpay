// classe para manipular a tabela de usuários
package com.desafiopicpay.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.desafiopicpay.domain.user.User;

public interface UserRepository extends JpaRepository<User, Long> {
    
    // consulta pelo documento e retorna o usuario caso encontre
    Optional <User> findUserByDocument(String document);

    // consulta pelo id  e retorna o usuario caso encontre
    Optional <User> findUserById(Long id);
}
