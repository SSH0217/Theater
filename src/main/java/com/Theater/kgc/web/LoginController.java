package com.Theater.kgc.web;

import com.Theater.domain.Member;
import com.Theater.kgc.dto.LoginForm;
import com.Theater.kgc.service.LoginService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Slf4j
@Controller
@RequiredArgsConstructor
public class LoginController {
    private final LoginService loginService;

    @GetMapping("/")
    public String home(
            @SessionAttribute(name = SessionConst.LOGIN_MEMBER, required = false) Member loginMember, Model model) {

        if (loginMember == null) {
            return "layouts/layout";
        }

        model.addAttribute("member",loginMember);

        return "layouts/layout";
    }

    @GetMapping("/login")
    public String loginForm(@ModelAttribute("loginForm") LoginForm loginForm){
        return "login/login-Form";
    }

    @PostMapping("/login")
    public  String login(@Validated @ModelAttribute LoginForm loginForm,
                         BindingResult bindingResult,
                         HttpServletRequest request){
//        if(bindingResult.hasErrors()){
//            return "login/login-Form";
//        }
        Member loginMember = loginService.login(loginForm.getLoginId(), loginForm.getPassword());
        if(loginMember == null){
            bindingResult.reject("loginFail","아이디 또는 비밀번호가 맞지 않습니다.");
            return "login/login-Form";
        }
        //로그인 성공 처리
        //세션이 있으면 있는 세션반환, 없으면 신규 세션을 생성
        HttpSession session = request.getSession();
        session.setAttribute(SessionConst.LOGIN_MEMBER, loginMember);
        System.out.println("로그인! : "+loginMember.getLoginId());
        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        if(session!=null){
            session.invalidate();
        }
        System.out.println("로그아웃!");
        return "redirect:/";
    }
}
