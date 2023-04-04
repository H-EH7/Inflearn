package hello.springmvc.basic;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController // 메서드에서 반환되는 String을 HTTP 메시지 바디에 바로 입력
public class LogTestController {
//    private final Logger log = LoggerFactory.getLogger(getClass());

    @RequestMapping("/log-test")
    public String logTest() {
        String name = "Spring";

        System.out.println("name = " + name);
        log.trace("trace log=" + name); // 이런 식으로 사용하면 trace 레벨이 아니어도 문자열을 더하는 의미없는 연산이 일어남

        // 로그 레벨 trace > debug > info > warn > error
        // 개발 서버는 보통 debug
        // 운영 서버는 info (디폴트)
        log.trace("trace log={}", name);
        log.debug("debug log={}", name);
        log.info("info log={}", name);
        log.warn("warn log={}", name);
        log.error("error log={}", name);

        return "ok";
    }
}
