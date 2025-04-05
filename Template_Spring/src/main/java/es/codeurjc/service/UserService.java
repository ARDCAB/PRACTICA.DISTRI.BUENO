package es.codeurjc.service;


import es.codeurjc.model.User;
import org.springframework.stereotype.Service;

import java.util.*;
@Service
public class UserService {
    private Map<Integer, User> users = new HashMap<>();
    private int currentId = 1;

    public List<User> getAll() {
        return new ArrayList<>(users.values());
    }

    public User getById(int id) {
        return users.get(id);
    }

    public User create(User user) {
        user.setId(currentId++);
        users.put(user.getId(), user);
        return user;
    }

    public User update(int id, User user) {
        if (users.containsKey(id)) {
            user.setId(id);
            users.put(id, user);
            return user;
        }
        return null;
    }

    public User patch(int id, Map<String, Object> updates) {
        User user = users.get(id);
        if (user != null) {
            if (updates.containsKey("nombre")) {
                user.setNombre((String) updates.get("nombre"));
            }
            if (updates.containsKey("email")) {
                user.setEmail((String) updates.get("email"));
            }
        }
        return user;
    }

    public boolean delete(int id) {
        return users.remove(id) != null;
    }
}

