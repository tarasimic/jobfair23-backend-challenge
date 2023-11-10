    package com.nordeus.jobfair.auctionservice.auctionservice.config;

    import com.nordeus.jobfair.auctionservice.auctionservice.domain.service.auction.AuctionServiceImpl;
    import com.nordeus.jobfair.auctionservice.auctionservice.domain.model.Auction;
    import com.nordeus.jobfair.auctionservice.auctionservice.domain.model.User;
    import com.nordeus.jobfair.auctionservice.auctionservice.domain.service.user.UserService;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.context.annotation.Bean;
    import org.springframework.context.annotation.Configuration;
    import org.springframework.context.annotation.Scope;
    import org.springframework.scheduling.annotation.EnableScheduling;
    import org.springframework.scheduling.annotation.Scheduled;

    import java.util.ArrayList;
    import java.util.List;

    @Configuration
    @EnableScheduling
    public class Config {

        private int auctionCount = 0;
        private int userCount = 0;
        @Autowired
        private  AuctionServiceImpl auctionService;
        @Autowired
        private UserService userService;


        @Bean
        @Scope("prototype")
        public Auction auction(){
            return new Auction(auctionCount++);
        }


        @Scheduled(fixedRate = 60000)
        public void newAuctions(){
            List<Auction> auctions = new ArrayList<>();
            List<User> users = new ArrayList<>();
            for(int i = 0; i < 10; i++){
                auctions.add(auction());
                users.add(user());
                auctionService.join(auctions.get(i), users.get(i));
            }
            auctionService.addAuctions(auctions);
            userService.addUsers(users);

        }

        @Bean
        @Scope("prototype")
        public User user(){
            return new User(userCount++);
        }
    }
