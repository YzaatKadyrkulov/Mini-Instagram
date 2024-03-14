package service.serviceImpl;

import model.DataBase;
import model.User;
import service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    @Override
    public String register() {
        User user = new User();
        DataBase.users.add(user);
        return null;
    }

    @Override
    public String login(String email, String password) {
        return null;
    }

    @Override
    public User getUserByEmail(String email) {
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }
}
