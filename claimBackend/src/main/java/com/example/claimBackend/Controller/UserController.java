package com.example.claimBackend.Controller;

import java.util.Date;

import com.example.claimBackend.Service.UserService;
import com.example.claimBackend.dto.UserDTO;
import com.example.claimBackend.entity.User;
import org.springframework.beans.factory.annotation.Autowired;



import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * REST controller for managing users.
 * Provides endpoints for user registration, authentication, and management.
 */
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;  // Service layer handling the business logic for user operations.


  //register

     ///Login

    @GetMapping("/{userId}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long userId) {
        UserDTO user = userService.findUserById(userId);
        return ResponseEntity.ok(user);
    }

    /**
     * Updates user details.
     * @param userId The ID of the user to update.
     * @param updatedUser User entity with updated user details from the request body.
     * @return ResponseEntity with the updated user DTO.
     */
    @PutMapping("/{userId}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable Long userId, @RequestBody User updatedUser) {
        UserDTO user = userService.updateUser(userId, updatedUser);
        return ResponseEntity.ok(user);
    }

    /**
     * Deletes a user by their ID.
     * @param userId The ID of the user to delete.
     * @return ResponseEntity with HTTP status 204 (No Content) indicating successful deletion.
     */
    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
        return ResponseEntity.noContent().build();
    }
}