package com.test.springboot.repository;

import com.test.springboot.entity.DemoInfo;
import org.springframework.data.repository.CrudRepository;

public interface DemoInfoRepository extends CrudRepository<DemoInfo, Long> {
    public DemoInfo findByTitle(String title);
}
