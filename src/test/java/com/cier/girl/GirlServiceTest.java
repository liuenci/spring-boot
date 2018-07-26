package com.cier.girl;

import com.cier.girl.pojo.Girl;
import com.cier.girl.service.GirlService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

// 表示在测试环境里面测试
@RunWith(SpringRunner.class)
// 表示启动整个 Spring boot 的工程
@SpringBootTest
public class GirlServiceTest {
    @Autowired
    private GirlService girlService;

    @Test
    public void findOneTest() {
        Girl girl = girlService.findOne(10);
        Assert.assertEquals(new Integer(10),girl.getAge());
    }
}
