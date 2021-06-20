package jp.kobespiral.hello;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HelloRestController {
    @GetMapping("/{name}/hello")
    public String sayHelloGetMethod(@PathVariable String name) {
        return name + "さん、HTTP-GETはリソースを取得するときに用います";
    }

    @PostMapping("/{name}/hello")
    public String sayHelloPostMethod(@PathVariable String name) {
        return name + "さん、HTTP-POSTはリソースを追加するときに用います";
    }

    @PutMapping("/{name}/hello")
    public String sayHelloPutMethod(@PathVariable String name) {
        return name + "さん、HTTP-PUT はリソースを削除するときに用います";
    }

    @DeleteMapping("/{name}/hello")
    public String sayHelloDeleteMethod(@PathVariable String name) {
        return name + "さん、HTTP-DELETE はリソースを削除するときに用います";
    }

}