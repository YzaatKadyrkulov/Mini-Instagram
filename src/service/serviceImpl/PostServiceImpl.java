package service.serviceImpl;

import model.DataBase;
import model.GenerateId;
import model.Post;
import model.User;
import service.PostService;

import javax.xml.crypto.Data;
import java.util.*;

public class PostServiceImpl implements PostService {

    @Override
    public String addPostToUser(Post post) {
        try {
            System.out.println("Enter your id: ");
            post.setId(new Scanner(System.in).nextLong());
            System.out.println("Enter your description of post: ");
            post.setDescription(new Scanner(System.in).nextLine());
            System.out.println("Find ImageUrl: ");
            post.setImageUrl(new Scanner(System.in).nextLine());

            DataBase.posts.add(post);

        } catch (InputMismatchException e) {
            System.out.println("You wrote not properly: " + e.getMessage());
        }
        return "Successfully added";
    }

    @Override
    public String deletePostById(Long postId) {
        for (Post post : DataBase.posts) {
            try {
                if (post.getId().equals(postId)) {
                    DataBase.posts.remove(post);
                    return "A post was deleted: ";
                }
            } catch (InputMismatchException e) {
                System.out.println("Are you stupid, instead of words you must write numbers. " + e.getMessage());
            }
        }
        return "The post with " + postId + " not found ";
    }

    @Override
    public List<Post> getPostsByUserId(Long userId) {
        for (User user : DataBase.users) {
            try {
                if (user.getId().equals(userId)) {
                    StringBuilder getUserId = new StringBuilder(String.valueOf(DataBase.posts));
                    System.out.println("The post with userId " + getUserId + " founded");
                }else{
                    System.out.println("The post with userId " + userId + " not found");
                    break;
                }


            } catch (InputMismatchException e) {
                System.out.println("Are you stupid, instead of words you must write numbers. " + e.getMessage());
            }
        }
        return null;
    }
}
