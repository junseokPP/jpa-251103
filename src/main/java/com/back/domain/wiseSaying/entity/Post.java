package com.back.domain.wiseSaying.entity;

import com.back.global.jpa.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@Setter
@ToString
@Entity
@NoArgsConstructor
public class Post extends BaseEntity {


    private String title;

    @Column(columnDefinition = "TEXT")
    private String content;


    public Post(String title, String content) {

        this.title = title;
        this.content = content;
    }
}
