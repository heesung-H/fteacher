package com.enola.fteacher.service;

import com.enola.fteacher.entity.Users;
import com.enola.fteacher.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ApiService {

    @Autowired
    private UsersRepository usersRepository;

    public List<?> findUserList() {
        return usersRepository.findAll();
    }

    @Transactional
    public Users insertUser(Users users) {
        return usersRepository.save(users);
    }

}
