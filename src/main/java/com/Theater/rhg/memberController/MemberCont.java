package com.Theater.rhg.memberController;

import com.Theater.domain.Member;
import com.Theater.rhg.Service.Service;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class MemberCont {
    private final Service memberSer;
    @GetMapping("/mypage")
    public String createForm(Model model){
        System.out.println("--------------------controller------------------------");
        Member mem= memberSer.findMembers("asd");
        System.out.println(mem.getLoginId());
        System.out.println(mem.getPassword());
        model.addAttribute("member",mem);
        return "member/member_info";
    }
}
