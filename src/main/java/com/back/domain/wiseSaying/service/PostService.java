package com.back.domain.wiseSaying.service;

import com.back.domain.wiseSaying.entity.Post;
import com.back.domain.wiseSaying.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;


    public void write(String title, String content) {
        Post post1 = new Post(title,content);
        postRepository.save(post1);
    }


    public Long count() {
       return postRepository.count();
    }

    public Optional<Post> getPost(int i) {
        return postRepository.findById(i);
    }

    public void delete(Post post1) {
        postRepository.delete(post1);
    }
}
