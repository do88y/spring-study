package jpabook.jpashop;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model) {  // model에 데이터를 실어서 view에 넘길 수 있음
        model.addAttribute("data", "hello!!!");
        return "hello";  // return은 화면 이름-> hello에 html이 자동으로 붙음
    }
}
