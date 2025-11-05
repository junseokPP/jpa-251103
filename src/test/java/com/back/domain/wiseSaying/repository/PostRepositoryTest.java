package com.back.domain.wiseSaying.repository;

import com.back.domain.wiseSaying.entity.Post;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class PostRepositoryTest {

    @Autowired
    private PostRepository postRepository;

    @Test
    @DisplayName("2번 글 조회")
    public void t1() {

        Post post = postRepository.findById(2).get();
        assertThat(post.getId()).isEqualTo(2);
        assertThat(post.getTitle()).isEqualTo("제목2");
        assertThat(post.getContent()).isEqualTo("내용2");
    }
}
