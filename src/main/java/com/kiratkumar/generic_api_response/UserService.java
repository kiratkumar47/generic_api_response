package com.kiratkumar.generic_api_response;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    List<User> users = new ArrayList<>();

    User save(User user) {
        users.add(user);
        return user;
    }

    User findById(Integer id) {
        for (User user: users) {
            if (user.getId().equals(id)) {
                return user;
            }
        }
        return null;
    }

    List<User> getAll() {
        return users;
    }
}
