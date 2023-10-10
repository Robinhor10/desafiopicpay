package com.desafiopicpay.services;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.desafiopicpay.domain.user.User;
import com.desafiopicpay.domain.user.UserType;
import com.desafiopicpay.dtos.UserDto;
import com.desafiopicpay.repositories.UserRepository;

@Service
public class UserService {
    
    @Autowired
    private UserRepository repository;

    public void validateTransaction(User sender, BigDecimal amount) throws Exception {

        if (sender.getUserType() == UserType.MERCHANT){
            throw new Exception("Usuario do tipo lojista(MERCHANT), nao esta autorizado a efetuar transacao");
        }

        if(sender.getBalance().compareTo(amount) < 0) {
            throw new Exception("Saldo Insuficiente");
        }

    }

    public User findUserById(Long id) throws Exception{
        return this.repository.findUserById(id).orElseThrow(() -> new Exception("Usuario nao encontrado"));
    }

    public User createUser(UserDto data){
        User newUser = new User(data);
        this.SaveUser(newUser);
        return newUser;
    }

    public List<User> getAllUsers(){
        return this.repository.findAll();
    }

    public void SaveUser(User user) {
        this.repository.save(user);
    }


}
