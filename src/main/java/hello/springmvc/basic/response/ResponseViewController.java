package hello.springmvc.basic.response;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ResponseViewController {

    @RequestMapping("/response-view-v1")
    public ModelAndView responseViewV1(){
        ModelAndView mav = new ModelAndView("response/hello")
                .addObject("data", "hello!");

        return mav;
    }

    @RequestMapping("/response-view-v2")
    public String responseViewV2(Model model){
        model.addAttribute("data", "Hello2!");

        return "response/hello";
    }

    //권장하지 않음!!
    @RequestMapping("/response/hello")//컨트롤러의 이름과 뷰의 논리적 이름이 동일하면 반환값이 없어도 논리적 이름으로 뷰가 불러짐
    public void responseViewV3(Model model){
        model.addAttribute("data", "Hello3!");
    }

}
