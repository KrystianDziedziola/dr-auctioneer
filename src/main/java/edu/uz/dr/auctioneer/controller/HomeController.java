package edu.uz.dr.auctioneer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String home() {
        return "redirect:/auctions";
    }

    @RequestMapping("/home")
    public String homepage() {
        return "homepage";
    }
}
