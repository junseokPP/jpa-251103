package com.back.global.initData;

import com.back.domain.wiseSaying.entity.Post;
import com.back.domain.wiseSaying.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Optional;

@Configuration
@RequiredArgsConstructor
public class BaseInitData {

    private final PostService postService;

    @Bean
    ApplicationRunner initData(){
        return args -> {


            work1();
            work2();

        };
    }

    private void work2() {
        Optional<Post> post = postService.getPost(1);
    }

    public void work1(){
        if(postService.count()>0){
            return;
        }
        postService.write("제목1","내용1");
        postService.write("제목2","내용2");
    }
}
