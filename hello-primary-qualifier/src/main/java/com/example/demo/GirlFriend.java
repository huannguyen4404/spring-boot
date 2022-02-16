package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class GirlFriend {
//    @Autowired
//    @Qualifier("biki-ni")
    public Outfit outfit;

    public GirlFriend() {
    }

    @Autowired
    public GirlFriend(@Qualifier("biki-ni") Outfit outfit) {
        this.outfit = outfit;
    }

    public Outfit getOutfit() {
        return outfit;
    }

    public void setOutfit(Outfit outfit) {
        this.outfit = outfit;
    }
}
