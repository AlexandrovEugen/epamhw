package com.epam.java.se.hw7;

import java.lang.annotation.*;


@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Move {

    boolean enginIsStared();
}
