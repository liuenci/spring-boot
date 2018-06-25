package com.cier.girl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GirlService {
    @Autowired
    private GirlRepository girlRepository;
    @Transactional
    public void insertTwo(){
        Girl girl1 = new Girl();
        girl1.setCupSize("A");
        girl1.setAge(18);
        girlRepository.save(girl1);

        int a = 1/0;
        Girl girl2 = new Girl();
        girl2.setCupSize("B");
        girl2.setAge(17);
        girlRepository.save(girl2);
    }
}
