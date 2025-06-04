//package com.example.BlocNotas.repository;
//
//
//import com.example.BlocNotas.model.Post;
//import org.springframework.stereotype.Repository;
//import java.util.ArrayList;
//import java.util.List;
//
//@Repository
//public class PostRepository implements IpostRepository{
//    private final List<Post> posts = new ArrayList<>();
//
//    @Override
//    public List<Post> findAll() {
//        return posts;
//    }
//
//    @Override
//    public Post findById(Long id) {
//        for (Post post:posts){
//            if (post.getId_Post().equals(id)){
//                return post;
//            }
//        }
//        return null;
//    }
//
//    @Override
//    public void save(Post post) {
//        posts.add(post);
//    }
//}
