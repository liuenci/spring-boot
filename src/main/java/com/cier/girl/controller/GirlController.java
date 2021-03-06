package com.cier.girl.controller;

import com.cier.girl.pojo.Result;
import com.cier.girl.service.GirlRepository;
import com.cier.girl.service.GirlService;
import com.cier.girl.pojo.Girl;
import com.cier.girl.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class GirlController {
    @Autowired
    public GirlRepository girlRepository;
    @Autowired
    public GirlService girlService;

    private static final Logger logger = LoggerFactory.getLogger(GirlController.class);

    /**
     * 查询所有女生接口
     *
     * @return
     */
    @GetMapping(value = "/girls")
    public List<Girl> getGirlList() {
        logger.info("girlList");
        return girlRepository.findAll();
    }

    @PostMapping(value = "/girls")
    public Result<Girl> girlAdd(@Valid Girl girl, BindingResult binding) {
        if (binding.hasErrors()) {
            return ResultUtil.error(1, binding.getFieldError().getDefaultMessage());
        }
        girl.setCupSize(girl.getCupSize());
        girl.setAge(girl.getAge());

        return ResultUtil.success(girlRepository.save(girl));
    }

    @GetMapping(value = "/girls/{id}")
    public Girl findGirl(@PathVariable("id") Integer id) {
        return girlRepository.findOne(id);
    }

    @PutMapping(value = "/girls/{id}")
    public Girl updateGirl(@PathVariable("id") Integer id, @RequestParam("cupSize") String cupSize, @RequestParam("age") Integer age) {
        Girl girl = new Girl();
        girl.setId(id);
        girl.setCupSize(cupSize);
        girl.setAge(age);
        girlRepository.save(girl);
        return girl;
    }

    @DeleteMapping(value = "/girls/{id}")
    public void deleteGirl(@PathVariable("id") Integer id) {
        girlRepository.delete(id);
    }

    @GetMapping(value = "/girls/age/{age}")
    public List<Girl> findGirlByAge(@PathVariable("age") Integer age) {
        return girlRepository.findByAge(age);
    }

    @PostMapping(value = "/girls/two")
    public void insertTwo() {
        girlService.insertTwo();
    }

    @GetMapping(value = "girls/get_age/{id}")
    public void getAge(@PathVariable("id") Integer id) throws Exception {
        girlService.getAge(id);
    }
}
