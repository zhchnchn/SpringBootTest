package com.test.springboot.web;

import com.test.springboot.entity.DemoInfo;
import com.test.springboot.repository.DemoInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoInfoController {

    @Autowired
    private DemoInfoRepository demoInfoRepository;

    /**
     * 保存数据.
     */
    @RequestMapping("/save")
    public String save() {
        // 内存数据库操作
        demoInfoRepository.save(new DemoInfo("title1", "content1"));
        demoInfoRepository.save(new DemoInfo("title2", "content2"));
        demoInfoRepository.save(new DemoInfo("title3", "content3"));
        demoInfoRepository.save(new DemoInfo("title4", "content4"));
        demoInfoRepository.save(new DemoInfo("title5", "content5"));
        return "save ok";
    }

    /**
     * 获取所有数据.
     *
     * @return
     */
    @RequestMapping("/findAll")
    public Iterable<DemoInfo> findAll() {
        // 内存数据库操作
        return demoInfoRepository.findAll();
    }

}