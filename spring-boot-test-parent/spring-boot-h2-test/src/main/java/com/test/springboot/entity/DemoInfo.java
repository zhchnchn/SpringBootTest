package com.test.springboot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DemoInfo {
    @Id
    @GeneratedValue
    private long   id;
    private String title;
    private String content;

    public DemoInfo(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
