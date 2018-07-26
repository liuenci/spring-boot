package com.cier.girl.service;

import com.cier.girl.enums.ResultEnum;
import com.cier.girl.exception.GirlException;
import com.cier.girl.pojo.Girl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GirlService {
    @Autowired
    private GirlRepository girlRepository;

    @Transactional
    public void insertTwo() {
        Girl girl1 = new Girl();
        girl1.setCupSize("A");
        girl1.setAge(18);
        girlRepository.save(girl1);

        int a = 1 / 0;
        Girl girl2 = new Girl();
        girl2.setCupSize("B");
        girl2.setAge(17);
        girlRepository.save(girl2);
    }


    public void getAge(Integer id) throws Exception {
        Girl girl = girlRepository.findOne(id);
        Integer age = girl.getAge();
        if (age < 10) {
            // 返回“你还在上小学吧”
            throw new GirlException(ResultEnum.PRIMARY_SCHOOL);
        } else if (age > 10 && age < 16) {
            // 返回“你可能在上初中吧”
            throw new GirlException(ResultEnum.MIDDLE_SCHOOL);
        }
    }

    /**
     * 通过 id 查询一个女生的信息
     * @param id
     * @return
     */
    public Girl findOne(Integer id) {
        return girlRepository.findOne(id);
    }
}
