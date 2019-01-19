package com.mynotes.lomboktest.getters.setters;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

public class User {

    @Getter
    @Setter
    private String name;

    @Setter(AccessLevel.PROTECTED)
    private String email;

}
