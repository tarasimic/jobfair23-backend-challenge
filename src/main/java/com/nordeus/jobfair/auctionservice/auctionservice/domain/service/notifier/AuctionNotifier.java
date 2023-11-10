package com.nordeus.jobfair.auctionservice.auctionservice.domain.service.notifier;

import com.nordeus.jobfair.auctionservice.auctionservice.domain.model.Auction;
import com.nordeus.jobfair.auctionservice.auctionservice.domain.model.Bid;

import java.util.Collection;

public interface AuctionNotifier {

    void auctionFinished(Auction auction);

    void bidPlaced(Bid bid);

    void activeAuctionsRefreshed(Collection<Auction> activeAuctions);
}
