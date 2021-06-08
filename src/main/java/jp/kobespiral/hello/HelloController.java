package jp.kobespiral.hello;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

    private ArrayList<String> list = new ArrayList<>();

    @GetMapping("{name}/hello")
    public String SayHelloRequestParam(@PathVariable String name, Model model) {
        model.addAttribute("greeting", createGreetingMessage());
        model.addAttribute("name", name);
        return "hello";
    }

    @PostMapping("{name}/hello/add")
    public String addHello(@PathVariable String name, @RequestParam("text") String text, Model model) {
        list.add(text);
        model.addAttribute("greeting", text);
        model.addAttribute("name", name);
        return "post_hello";
    }

    private String createGreetingMessage() {

        String greeting = "";
        for (String s : this.list) {
            greeting = greeting + s + "、";
        }
        return greeting;
    }
}