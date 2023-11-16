package com.tugas.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.tugas.crud.model.User;
import com.tugas.crud.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> listUsers() {
        return (List<User>) userRepository.findAll();
    }

    public Page<User> listUsers(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        return this.userRepository.findAll(pageable);
    }
    
    public User addUser(User user) {
        return userRepository.save(user);
    }
    
    public void deleteUser(User user) {
        userRepository.delete(user);
    }
    
    public void deleteUserById(String id) {
        userRepository.deleteById(id);
    }
}
