package edu.uz.dr.auctioneer.controller;

import edu.uz.dr.auctioneer.model.auction.Auction;
import edu.uz.dr.auctioneer.model.auction.error.TooSmallBidValueException;
import edu.uz.dr.auctioneer.model.request.AddAuctionRequest;
import edu.uz.dr.auctioneer.model.request.BidRequest;
import edu.uz.dr.auctioneer.model.request.DeleteAuctionRequest;
import edu.uz.dr.auctioneer.model.request.EditAuctionRequest;
import edu.uz.dr.auctioneer.service.AuctionService;
import edu.uz.dr.auctioneer.service.error.WrongPasswordException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
        model.addAttribute("auction", new AddAuctionRequest());
        return "new_auction";
    }

    @RequestMapping(value = "/add_auction", method = RequestMethod.POST)
    public String addAuction(@Valid @ModelAttribute("auction") final AddAuctionRequest addAuctionRequest,
                             final BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "new_auction";
        }
        auctionService.add(addAuctionRequest.buildAuction());

        return "redirect:/auctions";
    }

    @RequestMapping(value = "/auction/{title}", method = RequestMethod.GET)
    public String auction(@PathVariable final String title,
                          final Model model) {
        final Auction auction = auctionService.findByTitle(title);
        model.addAttribute("auction", auction);
        model.addAttribute("bidRequest", new BidRequest());
        return "auction";
    }

    @RequestMapping(value = "/delete_auction", method = RequestMethod.GET)
    public String auctionToDelete(final Model model) {
        model.addAttribute("request", new DeleteAuctionRequest());
        model.addAttribute("auctions", auctionService.getAll());
        return "delete_auction";
    }

    @RequestMapping(value = "/auction/{title}/bid", method = RequestMethod.POST)
    public String bid(@PathVariable final String title,
                      @ModelAttribute("bidRequest") final BidRequest bidRequest) {
        try {
            final Auction auction = auctionService.findByTitle(title);
            auction.addBid(bidRequest.getAmount(), bidRequest.getUsername());
            auctionService.add(auction);
        } catch (final TooSmallBidValueException e) {
            return "bid_error";
        }

        return String.format("redirect:/auction/%s", title);
    }

    @RequestMapping(value = "/auction/delete", method = RequestMethod.GET)
    public String deleteAuction(@ModelAttribute("request") final DeleteAuctionRequest request) {
        final String title = request.getTitle();
        final String password = request.getPassword();

        try {
            auctionService.deleteByTitle(title, password);
        } catch (final WrongPasswordException e) {
            return "wrong_password";
        }
        return "redirect:/";
    }

    @RequestMapping(value = "/edit_auction/{title}", method = RequestMethod.GET)
    public String editAuction(final Model model) {
        model.addAttribute("auction", new EditAuctionRequest());
        return "redirect:/edit_auction";
    }

    @RequestMapping(value = "/edit_auction/{title}/edit", method = RequestMethod.POST)
    public String editAuction(@PathVariable final String title,
            @ModelAttribute("request") final EditAuctionRequest request) {
        try {
            final Auction auction = new EditAuctionRequest().buildAuction();
            auctionService.deleteByTitle(title, request.getPassword());
            auctionService.add(auction);
        } catch (WrongPasswordException e) {
            e.printStackTrace();
        }
        return "redirect:/";
    }
}
