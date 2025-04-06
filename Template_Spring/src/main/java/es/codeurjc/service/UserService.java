package es.codeurjc.service;

import es.codeurjc.model.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {

    // Mapa para almacenar los usuarios en memoria
    private Map<Integer, User> users = new HashMap<>();
    private int currentId = 1;

    // Instancia de BCryptPasswordEncoder para cifrar contraseñas
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    // Obtener todos los usuarios
    public List<User> getAll() {
        return new ArrayList<>(users.values());
    }

    // Obtener un usuario por su ID
    public User getById(int id) {
        return users.get(id);
    }

    // Crear un nuevo usuario (cifrado de contraseña)
    public User create(User user) {
        user.setId(currentId++);

        // Encriptar la contraseña antes de guardarla
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        users.put(user.getId(), user);
        return user;
    }

    // Actualizar un usuario por su ID
    public User update(int id, User user) {
        if (users.containsKey(id)) {
            user.setId(id);
            users.put(id, user);
            return user;
        }
        return null;
    }

    // Actualizar parcialmente un usuario (por ejemplo, nombre y email)
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

    // Eliminar un usuario por ID
    public boolean delete(int id) {
        return users.remove(id) != null;
    }

    // Autenticar un usuario (compara la contraseña proporcionada con la almacenada)
    public boolean authenticate(String username, String password) {
        // Buscar el usuario por nombre de usuario (puedes usar username si se agrega en el User)
        User user = users.values().stream()
                .filter(u -> u.getEmail().equals(username)) // Ahora es por email
                .findFirst()
                .orElse(null);

        if (user == null) {
            return false;  // Si no existe el usuario, autenticación falla
        }

        // Verificar que la contraseña proporcionada coincida con la almacenada (cifrada)
        return passwordEncoder.matches(password, user.getPassword());
    }
}
