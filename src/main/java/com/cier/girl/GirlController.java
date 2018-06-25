package com.cier.girl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GirlController {
    @Autowired
    public GirlRepository girlRepository;
    @Autowired
    public GirlService girlService;
    /**
     * 查询所有女生接口
     * @return
     */
    @GetMapping(value = "/girls")
    public List<Girl> getGirlList(){
        return girlRepository.findAll();
    }
    @PostMapping(value = "/girls")
    public Girl girlAdd(@RequestParam("cupSize") String cupSize,@RequestParam("age") Integer age){
        Girl girl = new Girl();
        girl.setCupSize(cupSize);
        girl.setAge(age);
        girlRepository.save(girl);
        return girl;
    }

    @GetMapping(value = "/girls/{id}")
    public Girl findGirl(@PathVariable("id") Integer id){
        return girlRepository.findOne(id);
    }

    @PutMapping(value = "/girls/{id}")
    public Girl updateGirl(@PathVariable("id") Integer id,@RequestParam("cupSize") String cupSize,@RequestParam("age") Integer age){
        Girl girl = new Girl();
        girl.setId(id);
        girl.setCupSize(cupSize);
        girl.setAge(age);
        girlRepository.save(girl);
        return girl;
    }
    @DeleteMapping(value = "/girls/{id}")
    public void deleteGirl(@PathVariable("id") Integer id){
        girlRepository.delete(id);
    }

    @GetMapping(value = "/girls/age/{age}")
    public List<Girl> findGirlByAge(@PathVariable("age") Integer age){
        return girlRepository.findByAge(age);
    }
    @PostMapping(value = "/girls/two")
    public void insertTwo(){
        girlService.insertTwo();
    }
}
