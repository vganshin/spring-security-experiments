package me.vlad.dao;

import me.vlad.model.User;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by vganshin on 31.10.15.
 */
public class UserDao {

    private Map<Long, User> users = new HashMap<Long, User>();
    private AtomicLong sequence = new AtomicLong(0);

    public UserDao() {
        saveUser(new User("jsmith@mail.com", "wow"));
        saveUser(new User("sbrown@mail.com", "wow"));
    }

    public List<User> getAllUsers() {
        return new ArrayList<User>(users.values());
    }

    public User findUserById(Long id) {
        return users.get(id);
    }

    public User saveUser(User user) {
        if (user.getId() == null) {
            user.setId(sequence.getAndIncrement());
        }
        users.put(user.getId(), user);
        return user;
    }
}
