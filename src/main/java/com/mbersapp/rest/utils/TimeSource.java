package com.mbersapp.rest.utils;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class TimeSource {

    public Date getCurrentTime() {
        return new Date();
    }
}
