package com.cier.girl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")
public class HelloController {
    @Autowired
    private GirlProperties girlProperties;

    @RequestMapping(value = {"/hello", "/hi"}, method = RequestMethod.GET)
    public String say() {
        return girlProperties.getCupSize();
    }

    @RequestMapping(value = "{id}/say", method = RequestMethod.GET)
    public String sayHello(@PathVariable Integer id) {
        return "id="+id;
//        return "ssass";
    }

    @RequestMapping(value = "/say1", method = RequestMethod.GET)
    public String sayValue1(@RequestParam("id") Integer myId) {
        return "id="+myId;
    }
    @RequestMapping(value = "/say2", method = RequestMethod.GET)
    public String sayValue2(@RequestParam(value = "id",defaultValue = "0") Integer myId) {
        return "id="+myId;
    }

    @GetMapping(value = "/say3")
    public String sayValue3(@RequestParam(value = "id",defaultValue = "0") Integer myId) {
        return "id="+myId;
    }
}
