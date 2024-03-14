package service.serviceImpl;

import model.DataBase;
import model.Post;
import service.PostService;

import java.util.List;

public class PostServiceImpl implements PostService {

    @Override
    public String addPostToUser(Post post) {
        DataBase.posts.add(post);
        return "Success added!";
    }

    @Override
    public String deletePostById(Long postId) {
        return null;
    }

    @Override
    public List<Post> getPostsByUserId(Long userId) {
        return null;
    }
}
