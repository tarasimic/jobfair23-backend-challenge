package com.nordeus.jobfair.auctionservice.auctionservice.domain.model;

import lombok.Data;

@Data
public class AuctionUserDTO {
    private Auction auction_id;
    private User user_id;
}
