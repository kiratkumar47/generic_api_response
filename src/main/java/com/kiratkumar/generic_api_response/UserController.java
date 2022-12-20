package com.kiratkumar.generic_api_response;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<ApiResponse<User>> saveUser(@RequestBody User user) {
        if (user.getId() == null) {
            return ResponseEntity.ok(new ApiResponse<>(false, "Please enter id.", null));
        }
        if (user.getName() == null || user.getName().isEmpty()) {
            return ResponseEntity.ok(new ApiResponse<>(false, "Please enter name.", null));
        }
        user = userService.save(user);
        return ResponseEntity.ok(new ApiResponse<>(true, "Success", user));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<User>> getUser(@PathVariable Integer id) {
        User user = userService.findById(id);
        if (user == null) {
            return ResponseEntity.ok(new ApiResponse<>(false, "User not found", null));
        }
        return ResponseEntity.ok(new ApiResponse<>(true, "Success", user));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<User>>> getUsers() {
        List<User> users = userService.getAll();
        return ResponseEntity.ok(new ApiResponse<>(true, "Success", users));
    }

}
