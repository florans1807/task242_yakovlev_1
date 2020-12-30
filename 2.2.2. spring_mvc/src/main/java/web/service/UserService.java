package web.service;

import org.springframework.stereotype.Component;
import web.model.User;

import java.util.ArrayList;
import java.util.List;


@Component
public class UserService {
    private static int counter;
    private List<User> users;

    {
        users = new ArrayList<>();

        users.add(new User(++counter, "Tom", "asx"));
        users.add(new User(++counter, "Bob", "sxaxa"));
        users.add(new User(++counter, "Mike", "daxxa"));
        users.add(new User(++counter, "Katy", "dekosxk"));
    }

    public List<User> index() {
        return users;
    }

    public User show(int id) {
        return users.stream().filter(user -> user.getId() == id).findAny().orElse(null);
    }

    public void save(User user) {
        user.setId(++counter);
        users.add(user);
    }

    public void update(int id, User updatedUser) {
        User userToBeUpdated = show(id);
        userToBeUpdated.setName(updatedUser.getName());
        userToBeUpdated.setSurname(updatedUser.getSurname());
    }

    public void delete(int id) {
        users.removeIf(user -> user.getId() == id);
    }
}