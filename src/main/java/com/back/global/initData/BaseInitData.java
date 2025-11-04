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
            System.out.println("초기 데이터를 로딩합니다.");

            Post post = new Post();
            post.setTitle("첫번째 제목");
            post.setContent("첫번째 게시글을 업로드 합니다.");

        };
    }
}
