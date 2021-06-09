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
    //あいさつのリスト
    private ArrayList<String> list = new ArrayList<>();

    /**
     * HTTP-GET で 猫ちゃんのあいさつページを表示する
     * @return あいさつページ
     */
    @GetMapping("/{name}/hello")
    public String SayHelloRequestParam(@PathVariable String name, Model model) {
        model.addAttribute("greeting", createGreetingMessage()); //あいさつ文セット
        model.addAttribute("name", name);    //ユーザ名セット
        return "hello";                      //テンプレ hello.htmlをレンダリング
    }

    /**
     * HTTP-POST であいさつ文が追加されたときのふるまい 
     * @return あいさつ追加ページ
     */
    @PostMapping("/{name}/hello/add")
    public String addHello(@PathVariable String name, @RequestParam("text") String text, Model model) {
        list.add(text);
        model.addAttribute("greeting", text); //追加されたあいさつをセット
        model.addAttribute("name", name);     //ユーザ名セット
        return "post_hello";                  //テンプレ post_hello.htmlをレンダリング
    }

    /**
     * 登録済みのあいさつを連結して、文字列にして返す
     * @return 登録されたあいさつ文字列
     */
    private String createGreetingMessage() {

        String greeting = "";
        for (String s : this.list) {
            greeting = greeting + s + "、";
        }
        return greeting;
    }
}