package edu.uz.dr.auctioneer.controller;

import edu.uz.dr.auctioneer.service.AuctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    private final AuctionService auctionService;

    @Autowired
    public HomeController(final AuctionService auctionService) {
        this.auctionService = auctionService;
        auctionService.addExamples();
    }

    @RequestMapping("/")
    public String home(final Model model) {
        model.addAttribute("auctions", auctionService.getAll());
        return "home";
    }
}
