package edu.uz.dr.auctioneer.controller;

import edu.uz.dr.auctioneer.model.request.AuctionRequest;
import edu.uz.dr.auctioneer.service.AuctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class AuctionsController {

    private final AuctionService auctionService;

    @Autowired
    public AuctionsController(final AuctionService auctionService) {
        this.auctionService = auctionService;

        if (auctionService.getAll().isEmpty()) {
            auctionService.addExamples();
        }
    }

    @RequestMapping(value = "/auctions", method = RequestMethod.GET)
    public String auctions(final Model model) {
        model.addAttribute("auctions", auctionService.getAll());
        return "auctions";
    }

    @RequestMapping(value = "/new_auction", method = RequestMethod.GET)
    public String newAuction(final Model model) {
        model.addAttribute("auction", new AuctionRequest());
        return "new_auction";
    }

    @RequestMapping(value = "/add_auction", method = RequestMethod.POST)
    public String addAuction(@Valid @ModelAttribute("auction") final AuctionRequest auctionRequest,
                             final BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "new_auction";
        }

        auctionService.add(auctionRequest.buildAuction());

        return "redirect:/auctions";
    }
}
