package com.nordeus.jobfair.auctionservice.auctionservice.domain.service.auction;

import com.nordeus.jobfair.auctionservice.auctionservice.domain.model.Auction;
import com.nordeus.jobfair.auctionservice.auctionservice.domain.model.User;

import java.util.List;

public interface AuctionService {

    List<Auction> getAllActive();

    void join(Auction auctionId, User user);

    void bid(Auction auctionId, User userId);
}
