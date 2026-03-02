package tests.utils;

import com.github.javafaker.Faker;

import java.util.Locale;

public class FakerProvider {

    private static final Faker faker = new Faker(Locale.of("ru"));
    private static final Faker fakerEn = new Faker(Locale.of("en"));


    private FakerProvider() {
    }

    public static Faker getFaker() {
        return faker;
    }

    public static Faker getFakerEn() {
        return fakerEn;
    }


}
