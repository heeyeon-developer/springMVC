package hello.springmvc.basic.request;

import hello.springmvc.basic.HelloData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@Slf4j
@Controller
public class RequestParamController {

    @RequestMapping("/request-param-v1")
    public void requestParamV1(HttpServletRequest request, HttpServletResponse response)throws IOException {
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));

        log.info("username={}, age={}", username, age);

        response.getWriter().write("ok");
    }
    @ResponseBody//이 애노테이션을 붙여주면 @RestController 랑 같은 의미로 htmlbody 에 return 스트링을 넣어준다, 뷰를 조회하지 않고 응답으로 바로 박히게 됨
    @RequestMapping("/request-param-v2")
    public String requestParamV2(
            @RequestParam("username") String memberName,
            @RequestParam("age") int memberAge){
        log.info("username={}, age={}", memberName,memberAge);
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/request-param-v3")
    public String requestParamV3(
            @RequestParam String username,
            @RequestParam int age){//파라미터 이름이 동일하면
        log.info("username={}, age={}", username,age);
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/request-param-v4")
    public String requestParamV4(String username,int age){//파라미터 이름이 동일해야 함
        log.info("username={}, age={}", username,age);
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/request-param-required")
    public String requestParamRequired(
            @RequestParam(required = true) String username,
            @RequestParam(required = false) Integer age){//required = true 가 default로 파라미터가 입력되지 않으면 오류, required = false 면 해당 파라미터값이 안와도 됨
        //required = false 를 쓰고 파라미터가 없다면 null 값이 들어가야 하는데 기본형인 int 에는 null 값이 들어갈 수 없으므로 객체형인 Integer 를 써주기
        log.info("username={}, age={}", username,age);
        return "ok";
    }

    @ResponseBody//이 애노테이션을 붙여주면 @RestController 랑 같은 의미로 htmlbody 에 return 스트링을 넣어준다, 뷰를 조회하지 않고 응답으로 바로 박히게 됨
    @RequestMapping("/request-param-default")
    public String requestParamDefault(
            @RequestParam(required = true, defaultValue = "guest") String username,
            @RequestParam(required = false, defaultValue = "-1") Integer age){
        //defaultValue 를 사용하게 되면 빈문자가 들어올 경우도 처리해 주기 때문에 빈문자일 경우 defaultValue 가 입력됨
        log.info("username={}, age={}", username,age);
        return "ok";
    }

    @ResponseBody//이 애노테이션을 붙여주면 @RestController 랑 같은 의미로 htmlbody 에 return 스트링을 넣어준다, 뷰를 조회하지 않고 응답으로 바로 박히게 됨
    @RequestMapping("/request-param-map")
    public String requestParamMap(@RequestParam Map<String, Object> paramMap){
        //파라미터 값이 1개가 확실하다면 Map 을 사용하면 되지만 확실하지 않다면 MultiValueMap 을 사용하기
        //MultiValueMap 은 동일한 이름의 파라미터의 값이 여러개일 경우 서로 다른 객체로 인식하게 만들어 줌
        log.info("username={}, age={}", paramMap.get("username"), paramMap.get("age"));
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/model-attribute-v1")
    public String modelAttributeV1(@ModelAttribute HelloData helloData){
        //@ModelAttribute 를 사용하면 선언된 객체가 자동으로 생성되어 요청 파라미터의 이름으로 getter, setter 가 실행되어 값이 바인딩 된다
//        HelloData helloData = new HelloData();
//        helloData.setUsername(username);
//        helloData.setAge(age);
        log.info("helloData={}",helloData);
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/model-attribute-v2")
    public String modelAttributeV2( HelloData helloData){
        //@RequestParam, @ModelAttribute 둘다 생략이 가능하다, 이때 스프링은 둘다 생략시에 어떻게 구별할까?
        //2개의 애노테이션을 모두 생략할 경우 단순 타입은 @RequestParam 으로 인식하고 나머지를 @ModelAttribute 로 인식 함
        //argument resolver 로 지정된 타입은 예외! ex) HttpServletResponse
        log.info("helloData={}",helloData);
        return "ok";
    }
}
