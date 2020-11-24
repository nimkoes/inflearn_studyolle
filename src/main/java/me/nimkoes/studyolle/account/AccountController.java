package me.nimkoes.studyolle.account;

import com.fasterxml.jackson.databind.jsontype.impl.SubTypeValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class AccountController {
    
    private final SignUpFormValidator signUpFormValidator;
    
    /*
     * validator 를 추가 해놓으면
     * signUpForm 을 받을 때, @InitBinder("signUpForm") 여기에 작성한 signUpForm 이것과
     * public String signUpSubmit(@Valid SignUpForm signUpForm, Errors errors) { 여기의 SignUpForm 이 매칭되어
     * validation 을 수행한다.
     *
     *  -> signUpSubmit 안에서 추가로 작성해줄 필요가 없다.
     */
    @InitBinder("signUpForm")
    public void initBinder(WebDataBinder webDataBinder) {
        webDataBinder.addValidators(signUpFormValidator);
    }
    
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
    
    @PostMapping("/sign-up")
    public String signUpSubmit(@Valid SignUpForm signUpForm, Errors errors) {
        /*
         * SignUpForm 의 Validation 이 실패하면 그 정보가 errors 에 담긴다.
         */
        if (errors.hasErrors()) {
            return "account/sign-up";
        }
        
        // TODO 회원 가입 처리
        return "redirect:/";
    }
}
