package hello.springmvc.basic;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController//RestController 라고 하면 반환한 문자 스트링 자체가 html body 에 반환이 됨
public class LogTestController {

    //@Slf4j 애노테이션을 사용하면 아래의 코드를 자동으로 넣어줌
//    private final Logger log = LoggerFactory.getLogger(getClass());//현재 클래스를 지정

    @RequestMapping("/log-test")
    public String logTest(){
        String name = "String";
//        System.out.println("name = " + name);

        //더하기 연산을 사용하여 로그를 출력하게 되면 trace 레벨로 로그를 보지 않을때에도 연산이 발생하면서 메모리, cpu를 사용하게 되므로 사용하면 안됨!!
//        log.trace("trace log=" + name);

        log.trace("trace log={}", name);
        log.debug("debug log={}", name);
        log.info("  info log={}", name);
        log.warn("  warn log={}", name);
        log.error("error log={}", name);

        return "ok";
    }
}
