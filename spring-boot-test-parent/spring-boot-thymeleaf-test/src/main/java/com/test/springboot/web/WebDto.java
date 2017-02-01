package com.test.springboot.web;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO: 数据传输对象(Data Transfer Object)
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WebDto {
    private String name;
    private String url;
}
