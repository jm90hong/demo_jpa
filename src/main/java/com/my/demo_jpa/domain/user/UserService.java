package com.my.demo_jpa.domain.user;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {


    @Autowired
    private UserRepository userRepository;

    //닉네임으로 조회
    public Optional<User> getUserByNick(String nick) {
        return userRepository.findByNick(nick);
    }

    //회원가입
    public User signUp(User user) {
        User savedUser = userRepository.save(user); 
        return savedUser;
    }

    //회원 전체 조회
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

}
