package service.serviceImpl;

import enums.Gender;
import model.DataBase;
import model.GenerateId;
import model.User;
import service.UserService;

import javax.xml.crypto.Data;
import java.util.InputMismatchException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class UserServiceImpl implements UserService {
    @Override
    public String register() {
        User user = new User();
        try {
            user.setId(GenerateId.genUserId());
            System.out.println("Write your full name: ");
            user.setFullName(new Scanner(System.in).nextLine());
            System.out.println("Write your email: ");
            user.setEmail(new Scanner(System.in).nextLine());
            System.out.println("Write your password: ");
            user.setPassword(new Scanner(System.in).nextLine());
            System.out.println("Write your id: ");
            user.setId(new Scanner(System.in).nextLong());
            System.out.println("Your gender (MALE/FEMALE: ");
            String genderInput = new Scanner(System.in).nextLine();
            if (genderInput.equals("MALE")) {
                user.setGender(Gender.MALE);
            } else if (genderInput.equals("FEMALE")) {
                user.setGender(Gender.FEMALE);
            } else {
                System.out.println("Invalid gender input. Setting gender to Unknown.");
                user.setGender(Gender.UNKNOWN);
            }
            DataBase.users.add(user);
        } catch (InputMismatchException e) {
            System.out.println("Write correct: " + e.getMessage());
        }
        return "User registered successfully";
    }


    @Override
    public String login(String email, String password) throws IllegalArgumentException {
        for (User user : DataBase.users) {
            if (user.getEmail().equals(email) && user.getEmail().contains("@") && user.getPassword().equals(password)) {
            } else {
                return "User didn't register successfully, because User's name must contains '@' and you must write correct your password ";

            }
        }
        return "User registered successfully";
    }

    @Override
    public User getUserByEmail(String email) {
        try {
            for (User user : DataBase.users) {
                if (user.getEmail().equals(email)) {
                    return user;
                }else{
                    System.err.println("Not correct: ");
                }
            }
        } catch (NoSuchElementException e) {
            System.out.println("User with email not found " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        return  DataBase.users;
    }
}


