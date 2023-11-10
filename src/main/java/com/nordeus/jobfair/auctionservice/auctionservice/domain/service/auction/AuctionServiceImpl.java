package com.nordeus.jobfair.auctionservice.auctionservice.domain.service.auction;

import com.nordeus.jobfair.auctionservice.auctionservice.domain.model.*;
import com.nordeus.jobfair.auctionservice.auctionservice.domain.service.auction.AuctionService;
import com.nordeus.jobfair.auctionservice.auctionservice.domain.service.notifier.AuctionNotifier;
import com.nordeus.jobfair.auctionservice.auctionservice.domain.service.user.UserService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
@AllArgsConstructor
@Getter
public class AuctionServiceImpl implements AuctionService {

    @Autowired
    private final AuctionNotifier auctionNotifier;
    private final List<Auction> auctions = new ArrayList<>();
    private final HashMap<Auction, User> joinedUsers = new HashMap<>();
    private final UserService userService;
    @Override
    public List<Auction> getAllActive() {
        return auctions;
    }

    public void addAuctions(List<Auction> newAuctions){
        auctions.addAll(newAuctions);
    }

    @Override
    public void join(Auction auction_id, User user_id) {
        if(auctions.contains(auction_id) && userService.getUsers().contains(user_id)) {
            joinedUsers.put(auction_id, user_id);
        }
    }

    @Override
    public void bid(Auction auctionId, User userId) {
        auctionNotifier.bidPlaced(new Bid());
    }
}
