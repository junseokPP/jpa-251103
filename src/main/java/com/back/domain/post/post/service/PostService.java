package com.back.domain.post.post.service;

import com.back.domain.post.post.entity.Post;
import com.back.domain.post.post.repository.PostRepository;
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

    public Long getTotalCount() {
       return postRepository.count();
    }

    public Optional<Post> getPost(int i) {
        return postRepository.findById(i);
    }

    public void delete(Post post1) {
        postRepository.delete(post1);
    }

    public void modify(Post post, String newTitle, String newContent) {
        post.setTitle(newTitle);
        post.setContent(newContent);
    }
}
