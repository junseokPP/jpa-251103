package com.back.domain.post.repository;

import com.back.domain.post.post.entity.Post;
import com.back.domain.post.post.repository.PostRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
@ActiveProfiles("test")
public class PostRepositoryTest {

    @Autowired
    private PostRepository postRepository;

    @Test
    @DisplayName("2번 글 조회")
    public void t1() {



        Post post2 = postRepository.findById(2).get();
        assertThat(post2.getId()).isEqualTo(2);
        assertThat(post2.getTitle()).isEqualTo("제목2");
        assertThat(post2.getContent()).isEqualTo("내용2");
    }

    @Test
    @DisplayName("새로운 글 생성")
    @Transactional
    @Rollback
    public void t2() {

        Post newPost = new Post("new제목","new내용");

        assertThat(newPost.getId()).isNull();

        Post saved = postRepository.save(newPost);

        assertThat(saved.getId()).isNotNull();
        assertThat(saved.getTitle()).isEqualTo(newPost.getTitle());
        assertThat(saved.getContent()).isEqualTo(newPost.getContent());

    }

    @Test
    @DisplayName("글 개수 조회")
    public void t3(){
        long cnt = postRepository.count();
        assertThat(cnt).isEqualTo(4);
    }
}
