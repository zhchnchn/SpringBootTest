package com.test.springboot.demoinfo;

import com.test.springboot.entity.DemoInfo;
import com.test.springboot.repository.DemoInfoRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

import static org.assertj.core.api.Java6Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class DemoInfoTest {

    @Autowired
    private DemoInfoRepository demoInfoRepository;

    @Before
    public void save() {
        DemoInfo info1 = new DemoInfo("Spring in Action", "content1");
        DemoInfo info2 = new DemoInfo("Spring Boot in Action", "content1");
        DemoInfo info3 = new DemoInfo("Spring Data in Action", "content1");
        demoInfoRepository.save(Arrays.asList(info1, info2, info3));
    }

    @After
    public void deleteAll() {
        demoInfoRepository.deleteAll();
    }

    @Test
    public void findAll() {
        assertThat(demoInfoRepository.findAll()).hasSize(3);
    }

    @Test
    public void findByTitle() {
        assertThat(demoInfoRepository.findByTitle("Spring in Action")).isNotNull();
        assertThat(demoInfoRepository.findByTitle("Spring in")).isNull();
    }

    @Test
    public void marge() {
        DemoInfo findByTitle = demoInfoRepository.findByTitle("Spring in Action");
        assertThat(findByTitle).isNotNull();

        findByTitle.setTitle("Spring in Action (4 Edition)");
        demoInfoRepository.save(findByTitle);

        assertThat(demoInfoRepository.findByTitle("Spring in Action")).isNull();
        assertThat(demoInfoRepository.findByTitle("Spring in Action (4 Edition)")).isNotNull();
    }

    @Test
    public void delete() {
        DemoInfo findByTitle = demoInfoRepository.findByTitle("Spring in Action");
        assertThat(findByTitle).isNotNull();

        demoInfoRepository.delete(findByTitle);

        assertThat(demoInfoRepository.findAll()).hasSize(2);
        assertThat(demoInfoRepository.findByTitle("Spring in Action")).isNull();
    }

}