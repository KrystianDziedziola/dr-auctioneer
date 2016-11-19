package edu.uz.dr.auctioneer;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GreetingControler {

    @RequestMapping("/test")
    public String greeting() {
        return "registration";
    }
}
