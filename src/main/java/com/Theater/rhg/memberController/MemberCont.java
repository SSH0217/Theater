package com.Theater.rhg.memberController;

import com.Theater.domain.Member;
import com.Theater.domain.Ticket;
import com.Theater.rhg.DTO.TicketDTO;
import com.Theater.rhg.Service.Service;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class MemberCont {
    private final Service memberSer;
    @GetMapping("/mypage")
    public String createForm(Model model){
        System.out.println("--------------------controller------------------------");
        List<Ticket> mem= memberSer.findMembers("asd");
        List<TicketDTO> ticketDTOList;
        TicketDTO ticketDTO;
        System.out.println(mem.size());
        //mem.stream().forEach(i-> System.out.println("isCanceled = " + i.isCanceled() + ", getId="+i.getScreen_t().getMovie().getTitle()+ ", getId="+i.getSeat().getId()));
        model.addAttribute("member",mem);
        return "/member/member_info";
    }
}
