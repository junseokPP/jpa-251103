package com.back.global.initData;

import com.back.domain.wiseSaying.entity.Post;
import com.back.domain.wiseSaying.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BaseInitData {

    @Autowired
    private PostRepository postRepository;

    @Bean
    ApplicationRunner initData(){
        return args -> {

            if(postRepository.count()>0){
                return;
            }

            work1();
            work2();
        };
    }

    private void work2() {
        postRepository.findById(1);
    }

    private void work1() {
        Post post1 = new Post("제목1","내용1");
        postRepository.save(post1);
        Post post2 = new Post("제목2","내용2");
        postRepository.save(post2);
    }
}
