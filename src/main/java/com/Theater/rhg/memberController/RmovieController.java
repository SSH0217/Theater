package com.Theater.rhg.memberController;

import com.Theater.rhg.DTO.AmountDTO;
import com.Theater.rhg.DTO.PercentDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
public class RmovieController {

    @PostMapping("/comment/new")
    public String createAdminForm2(@RequestParam("review") String review,
                                   @RequestParam("star") int star,
                                   @RequestParam("movId") int movId){
        System.out.println("--------------------controller------------------------");
            System.out.println(movId);
            System.out.println(review);
            System.out.println(star);
            return "redirect:/";

    }
}
