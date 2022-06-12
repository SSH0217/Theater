package com.Theater.kgc.web;

import com.Theater.domain.Member;
import com.Theater.kgc.dto.MemberForm;
import com.Theater.kgc.service.MemberService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@AllArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/members/new")
    public String createForm(Model model){
        model.addAttribute("member",new MemberForm());
        return "members/join-form";
    }
    @PostMapping("/members/new")
    public String addMember(@ModelAttribute MemberForm form){
        Member member = new Member();
        member.setName(form.getName());
        member.setLoginId(form.getId());
        member.setPassword(form.getPassword());
        member.setSocialSecurityNumber(form.getPhoneNumber());
        member.setSex(form.getSex());
        member.setAge(form.getAge());
        memberService.join(member);
        return "redirect:/";
    }
    @GetMapping("/members")
    public String list(Model model){
        List<Member> members = memberService.findMembers();
        List<MemberForm> memberList = members.stream()
                .map(m->new MemberForm(m))
                .collect(Collectors.toList());
        model.addAttribute("members",memberList);
        return "members/member-list";
    }
}
