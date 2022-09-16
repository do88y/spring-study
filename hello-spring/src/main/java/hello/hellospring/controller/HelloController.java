package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.awt.*;

@Controller
public class HelloController {

    @GetMapping("hello")  // 이렇게 하면 web application에서 /hello라고 들어오면 아래의 메서드를 실햏해 줌
    public String hello(Model model) {
        model.addAttribute("data", "hello!!");  // key가 data고 값이 hello!!
        return "hello";  // templates 밑의 hello를 찾음-> hello.html로 연결(con+hello클릭하면 해당 페이지로 이동)
    }

    // MVC방식으로 view를 찾아서 템플릿 엔진을 통해 렌더링 해서 HTML을 웹브라우저에 넘겨주는 방식
    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
        // viewResolver(뷰 관련된 작업 하는)가 templates에서 hello-template.html을 찾아서 템플릿엔진한테 넘김-> thymeleaf가 렌더링 해서 '변환 한' HTML을 넘김
    }

    // API방식-> 데이터로 바로 내림
    @GetMapping("hello-string")
    @ResponseBody  // http에서 head와 body가 있는데 그 body를 직접 넣겠다는 것
    public String helloString(@RequestParam("name")String name) {
        return "hello " + name;  // view 없이 여기에 있는 소스를 그대로 전달한다.
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();  // 객체 만듬
        hello.setName(name);
        return hello;  // 객체 반환-> json방식으로 data를 만들어서 반환하는 것이 기본으로 되어있음
    }

    static class Hello {  // static클래스로 클래스 안에 클래스를 만들었다.
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
