import model.DataBase;
import model.Post;
import model.User;
import service.PostService;
import service.UserService;
import service.serviceImpl.PostServiceImpl;
import service.serviceImpl.UserServiceImpl;

import javax.swing.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner1 = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);

        UserService userService = new UserServiceImpl();
        PostService postService = new PostServiceImpl();

        User user = new User();
        Post post = new Post();

        boolean registrationCompleted = false;
        boolean exitRequested = false;
        while (!exitRequested) {
            if (!registrationCompleted) {
                System.out.println("""
                        User's register
                        You should select step by step.
                        1.Register
                        2.Register by login and password""");

                int choice = scanner1.nextInt();

                if (choice == 1 || choice == 2) {
                    try {
                        if (choice == 1) {
                            System.out.println(userService.register());
                        } else {
                            String email;
                            do {
                                System.out.println("Write user's email: ");
                                email = scanner2.nextLine();
                                if (!email.contains("@")) {
                                    System.out.println("Invalid email address. Please include '@' in the email.");
                                }
                            } while (!email.contains("@"));

                            System.out.println("Write user's password: ");
                            String password = scanner2.nextLine();
                            System.out.println(userService.login(email, password));
                        }
                        registrationCompleted = true;
                    } catch (InputMismatchException e) {
                        System.out.println("Error occurred: " + e.getMessage());
                    }
                }
            } else {
                System.out.println("""
                        1.Get user by email
                        2.Get all users
                        3.Add post to user
                        4.Delete post by id
                        5.Get posts by user Id
                        6.Exit""");

                int choice = scanner1.nextInt();

                switch (choice) {
                    case 1:
                        try {
                            System.out.println("Write user's email to get all information's about him: ");
                            String UserSEmail = scanner2.nextLine();
                            System.out.println("User found: " + userService.getUserByEmail(UserSEmail));
                        } catch (Throwable e) {
                            System.out.println("Error occurred: " + e.getMessage());
                        }
                        break;
                    case 2:
                        try {
                            System.out.println("All information's about user: ");
                            System.out.println(userService.getAllUsers());
                        } catch (Throwable e) {
                            System.out.println("Error occurred: " + e.getMessage());
                        }
                        break;
                    case 3:
                        try {
                            if (!DataBase.users.isEmpty()) {
                                System.out.println("Add post: ");
                                System.out.println(postService.addPostToUser(new Post()));
                            } else {
                                System.out.println("Your post is empty: ");
                            }
                        } catch (Throwable e) {
                            System.out.println("Error occurred: " + e.getMessage());
                        }
                        break;
                    case 4:
                        try {
                            System.out.println("Enter a post of id: ");
                            Long id = scanner1.nextLong();
                            System.out.println(postService.deletePostById(id));
                        } catch (Throwable e) {
                            System.out.println("Error occurred: " + e.getMessage());
                        }
                        break;
                    case 5:
                        try {
                            if (!DataBase.posts.isEmpty()) {
                                System.out.println("This is id.");
                                System.out.println(postService.getPostsByUserId(new Scanner(System.in).nextLong()));
                            } else {
                                System.out.println("You haven't got user's post id.");
                            }
                        } catch (Throwable e) {
                            System.out.println("Error occurred: " + e.getMessage());
                        }
                        break;
                    case 6:
                        System.out.println("Going back to registration...");
                        registrationCompleted = false;
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a valid option.");
                        break;
                }
            }
        }
    }
}
