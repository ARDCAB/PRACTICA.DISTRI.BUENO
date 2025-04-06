package es.codeurjc.controller;

import es.codeurjc.model.User;
import es.codeurjc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    // Get all users
    @GetMapping
    @ResponseBody
    public List<User> getAll() {
        return userService.getAll();
    }

    // Get a user by ID
    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<User> getById(@PathVariable int id) {
        User user = userService.getById(id);
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // User not found
        }
        return new ResponseEntity<>(user, HttpStatus.OK); // OK response with user data
    }

    // Create a new user
    @PostMapping
    @ResponseBody
    public ResponseEntity<User> create(@RequestBody User user) {
        User createdUser = userService.create(user);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED); // 201 Created
    }

    // Update a user by ID
    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity<User> update(@PathVariable int id, @RequestBody User user) {
        User updatedUser = userService.update(id, user);
        if (updatedUser == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // User not found
        }
        return new ResponseEntity<>(updatedUser, HttpStatus.OK); // OK response with updated user data
    }

    // Partially update a user (for example, only changing some fields)
    @PatchMapping("/{id}")
    @ResponseBody
    public ResponseEntity<User> patch(@PathVariable int id, @RequestBody Map<String, Object> updates) {
        User patchedUser = userService.patch(id, updates);
        if (patchedUser == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // User not found
        }
        return new ResponseEntity<>(patchedUser, HttpStatus.OK); // OK response with patched user data
    }

    // Delete a user by ID
    @DeleteMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Void> delete(@PathVariable int id) {
        boolean deleted = userService.delete(id);
        if (!deleted) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // User not found
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT); // 204 No Content, successful deletion
    }
}
