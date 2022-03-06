package com.altay.utilities;

import com.github.javafaker.Faker;

public class YouTubeUtils {


    public static String fakeEmail() {
        Faker faker = new Faker();
        return faker.bothify("????@gmail.com");
    }

    public static String fakePassword() {
        Faker faker = new Faker();
        return faker.bothify("??##??##??");
    }


}
