package com.nordeus.jobfair.auctionservice.auctionservice.api;

import com.nordeus.jobfair.auctionservice.auctionservice.domain.model.AuctionUserDTO;
import com.nordeus.jobfair.auctionservice.auctionservice.domain.service.auction.AuctionServiceImpl;
import com.nordeus.jobfair.auctionservice.auctionservice.domain.model.Auction;
import com.nordeus.jobfair.auctionservice.auctionservice.domain.model.User;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/auctions")
public class HttpController {

    private AuctionServiceImpl auctionService;

    @GetMapping("/active")
    public Collection<Auction> getAllActive() {
        return auctionService.getAllActive();
    }

    @PostMapping("/join")
    public ResponseEntity<String> joinAuction(@RequestBody AuctionUserDTO auctionUserDTO){
        Auction auction_id = auctionUserDTO.getAuction_id();
        User user_id = auctionUserDTO.getUser_id();
        System.out.println(auctionService.getJoinedUsers());
        return ResponseEntity.ok("User: " + user_id +  " to auction: " + auction_id);
    }
}
