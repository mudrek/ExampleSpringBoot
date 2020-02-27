package com.example.demo.api.users;

import com.example.demo.api.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<UserDTO> findAll() {
        return userRepository.findAll().stream().map(UserDTO::new).collect(Collectors.toList());
    }

    public UserDTO findById(Long id) {
        return userRepository.findById(id).map(UserDTO::new).orElseThrow(() -> new ObjectNotFoundException("User not found"));
    }

    public UserDTO update(UserDTO userDTO, Long id) {
        return userRepository.findById(id).map(user -> {
            user.setName(userDTO.getName());
            user.setEmail(userDTO.getEmail());
            user.setUsername(userDTO.getUsername());

            return user;
        }).map(UserDTO::new)
                .orElseThrow(() -> new ObjectNotFoundException("User not found"));
    }

    public UserDTO save(UserDTO userDTO) {
        return new UserDTO(userRepository.save(new User(userDTO)));
    }

    public void delete(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("User not found"));
        userRepository.delete(user);
    }

}
