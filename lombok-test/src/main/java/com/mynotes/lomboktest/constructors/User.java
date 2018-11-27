package com.mynotes.lomboktest.constructors;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

//@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class User {

    private final String name;

    private String email;

}
