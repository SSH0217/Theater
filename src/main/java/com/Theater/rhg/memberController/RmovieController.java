package com.Theater.rhg.memberController;

import com.Theater.domain.Member;
import com.Theater.rhg.DTO.AmountDTO;
import com.Theater.rhg.DTO.PercentDTO;
import com.Theater.rhg.Service.Service;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@AllArgsConstructor
public class RmovieController {
    private final Service service;
    @PostMapping("/comment/new")
    public String createAdminForm2(@RequestParam("review") String review,
                                   @RequestParam("star") int star,
                                   @RequestParam("movId") Long movId, HttpServletRequest request){
        System.out.println("--------------------controller------------------------");
        Member loginMember = (Member) request.getSession().getAttribute("loginMember");
        System.out.println(loginMember.getLoginId());
            System.out.println(movId);
            System.out.println(review);
            System.out.println(star);
            service.registerReview(loginMember,review,star,movId);
            return "redirect:/";

    }
}
