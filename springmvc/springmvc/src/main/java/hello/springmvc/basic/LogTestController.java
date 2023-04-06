package hello.springmvc.basic;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class LogTestController {

//    private final Logger log = LoggerFactory.getLogger(getClass());//@Slf4j로 대체 가능

    @RequestMapping("/log-test")
    public String logTest() {
        String name = "Spring";

        System.out.println("name = " + name);//운영 서버에 모든 로그가 다 남으면 로그 폭탄 맞을 수 있다.

        //낮은 레벨 -> 높은 레벨
        log.trace("trace log={}", name);
        log.debug("debug log={}", name);//디버그 할 때 보는거라고 레벨을 알려 줌
        log.info("info log={}", name);//중요한 정보임을 알려 줌
        log.warn("warn log={}", name);
        log.error("error log={}", name);

        return "ok";
    }
}
