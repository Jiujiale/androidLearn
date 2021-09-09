package com.example.demo.util;

import java.util.Random;

public class MyUtil {
    public static int randomInt(int max, int min) {
        return new Random().nextInt(max - min + 1) + min;
    }
}
