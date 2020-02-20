package com.example.demo.api;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    public List<User> createUsers() {
        List<User> users = new ArrayList<>();
        users.add(new User("Pessoa 1", "pessoa_1", "pessoa1@email.com"));
        users.add(new User("Pessoa 2", "pessoa_2", "pessoa2@email.com"));
        users.add(new User("Pessoa 3", "pessoa_3", "pessoa3@email.com"));
        users.add(new User("Pessoa 4", "pessoa_4", "pessoa4@email.com"));
        return users;
    }

     public List<UserDTO> findAll() {
         List<User> users = createUsers();
         return users.stream().map(UserDTO::new).collect(Collectors.toList());
     }

}
