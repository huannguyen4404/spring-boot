package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GirlFriend {
    @Autowired
    public Outfit outfit;

    public GirlFriend() {
    }

//    @Autowired
    public GirlFriend(Outfit outfit) {
        this.outfit = outfit;
    }

//    @Autowired
    public void setOutfit(Outfit outfit) {
        this.outfit = outfit;
    }

    public Outfit getOutfit() {
        return outfit;
    }
}
