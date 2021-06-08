package jp.kobespiral.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api")
public class HelloRestController {
    @GetMapping("/hello")
    public String SayHelloRestRequestParam() {
        return "Hello APIをGETで呼び出しました！";
    }

    @PostMapping("/hello")
    public String SayHelloPostMethod(@RequestParam("name") String name) {
        return name + "さん、こんにちは！ hello APIをPOSTで呼び出しました！";
    }
}