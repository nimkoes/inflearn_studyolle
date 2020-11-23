package me.nimkoes.studyolle.account;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AccountController {

    @GetMapping("/sign-up")
    public String signUpForm(Model model) {
//        model.addAttribute("signUpForm", new SignUpForm());
        /*
         * model 의 attribute 이름과 클래스 이름이 동일하다면
         * SignUpForm -> signUpForm
         * 이름을 설정하지 않아도 된다.
         */
        model.addAttribute(new SignUpForm());
        return "account/sign-up";
    }
}
