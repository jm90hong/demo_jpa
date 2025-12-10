package com.my.demo_jpa.controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import com.my.demo_jpa.domain.user.UserService;
import com.my.demo_jpa.domain.user.User;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/nick/{nick}")
    public ResponseEntity<Map<String, Object>> getUserByNick(@PathVariable String nick) {
        Map<String, Object> response = new HashMap<>();
        Optional<User> user = userService.getUserByNick(nick);
        response.put("success", true);
        response.put("message", "회원 닉네임 조회 성공");
        response.put("user", user);

        if (user.isEmpty()) {
            response.put("success", false);
            response.put("message", "회원 닉네임 조회 실패");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }


    @GetMapping("/all")
    public ResponseEntity<Map<String, Object>> getAllUsers() {
        List<User> users = userService.getAllUsers();

        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "회원 전체 조회 성공");
        response.put("users", users);

        return ResponseEntity.status(HttpStatus.OK).body(response);
        
    }

    @PostMapping("/signup")
    public ResponseEntity<Map<String, Object>> signUp(@RequestBody User user) {
        User savedUser = userService.signUp(user);

        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "회원가입 성공");
        response.put("user", savedUser);

        if (savedUser == null) {
            response.put("success", false);
            response.put("message", "회원가입 실패");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }else{
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }
       
       
    }

}
