package com.mynotes.lomboktest.builder;

public class Main {

    public static void main(String[] args) {
        User user = new User.UserBuilder().email("test@test.com")
            .name("test name")
            .build();
        System.out.println(user.getEmail());
    }

}
