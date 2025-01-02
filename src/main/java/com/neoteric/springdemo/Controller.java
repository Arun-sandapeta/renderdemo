package com.neoteric.springdemo;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/home")
public class Controller {

    @GetMapping(value = "/hi")
    public String saiHi(){
        System.out.println("HI");
        return "HI";
    }

    @GetMapping(value = "/bye")
    public String saiBye(){
        System.out.println("BYE");
        return "BYE";
    }


    @GetMapping(value = "/hii")
    public String sayHi(@RequestParam String name) {
        return "Hi, " + name + "!";
    }

    @GetMapping(value = "/byee")
    public String sayBye(@RequestParam String name) {
        return "BYE, " + name + "!";
    }

    @GetMapping("/hi/{name}")
    public String sayHiWithPath(@PathVariable String name) {
        return "Hi, " + name + "!";
    }
    @GetMapping("/bye/{name}")
    public String sayByeWithPath(@PathVariable String name) {
        return "Bye, " + name + "!";
    }

    @PostMapping("/greet")
    public String greetUser(@RequestParam String name, @RequestParam int age) {
        return "Hello, " + name + "! Your age is " + age + ".";
    }

}
