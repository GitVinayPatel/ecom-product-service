package com.app.ecomproductservice.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/say")
public class SampleController {

    @GetMapping("/hello/{name}/{symbol}")
    public String sayHello(@PathVariable("name") String name, @PathVariable("symbol") String S)
    {
        return "Hello" + " " + name + " "+ S;
    }

    @GetMapping("/hi/{name}/{times}")
    public String sayHi(@PathVariable("name") String name,@PathVariable("times") int times) {
        String output = "";
        for (int i = 0; i < times; i++) {
            output = output + "Hi" + " " + name;
        }
        return output;
    }
}
