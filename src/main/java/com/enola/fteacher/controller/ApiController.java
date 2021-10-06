package com.enola.fteacher.controller;

import com.enola.fteacher.dto.UserDTO;
import com.enola.fteacher.entity.Users;
import com.enola.fteacher.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private ApiService apiService;

    @GetMapping("/users")
    public List<?> user() {
        return apiService.findUserList();
    }

    @PostMapping("/users")
    public Users addUser(UserDTO userDTO) {
        /* dto -> entity builder */
        Users users = new Users.UsersBuilder(userDTO).build();
        return apiService.insertUser(users);
    }

}
