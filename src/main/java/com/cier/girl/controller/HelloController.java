package com.cier.girl.controller;

import com.cier.girl.properties.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {
    @Autowired
    private GirlProperties girlProperties;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String say(ModelMap map) {
        map.addAttribute("host","ci");
        return "views/index";
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
