package com.nordeus.jobfair.auctionservice.auctionservice.domain.service.user;

import com.nordeus.jobfair.auctionservice.auctionservice.domain.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
@Getter
public class UserService {

    private final List<User> users = new ArrayList<>();

    public void addUsers(List<User> user){
        users.addAll(user);
    }
}
