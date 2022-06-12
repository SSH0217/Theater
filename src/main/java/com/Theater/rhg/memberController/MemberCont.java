package com.Theater.rhg.memberController;

import com.Theater.domain.Member;
import com.Theater.domain.Screen;
import com.Theater.domain.Ticket;
import com.Theater.rhg.DTO.ScreenDTO;
import com.Theater.rhg.DTO.TicketDTO;
import com.Theater.rhg.Service.ScreenService;
import com.Theater.rhg.Service.Service;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@AllArgsConstructor
public class MemberCont {
    private final Service memberSer;
    private final ScreenService screenService;
    @GetMapping("/mypage")
    public String createForm(Model model){
        System.out.println("--------------------controller------------------------");
        Member member=memberSer.findMem("asd");

        List<Ticket> mem= memberSer.findMembers(member.getId());
        List<TicketDTO> ticketDTOList = mem.stream()
                .map(m->new TicketDTO(m))
                .collect(Collectors.toList());
        model.addAttribute("member",member);
        model.addAttribute("Tickets",ticketDTOList);
        return "/member/member_info";
    }
    @GetMapping("/admin")
    public String createAdminForm(Model model){
        System.out.println("--------------------controller------------------------");
        List<Screen> scr= screenService.findScreens();
        List<ScreenDTO> scrList = scr.stream()
                .map(m->new ScreenDTO(m))
                .collect(Collectors.toList());
        model.addAttribute("Screens",scrList);
        return "/member/admin_page";
    }
    @PostMapping("/admin2")
    public String createAdminForm2(@RequestParam("movieId") Long movieId,
                                   @RequestParam("policy") boolean policy,
                                   @RequestParam int amount){
        System.out.println("--------------------controller------------------------");

        System.out.println(movieId);
        System.out.println(policy);
        System.out.println(amount);
        screenService.updatePolicy(movieId,policy,amount);
        return "redirect:/admin";
    }
}
