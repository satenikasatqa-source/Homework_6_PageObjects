package utils;

import com.github.javafaker.Faker;
import java.util.Locale;

public class FakerGenerator {
    private static final Faker faker = new Faker(new Locale("en"));

    public static String firstName() { return faker.name().firstName(); }
    public static String lastName() { return faker.name().lastName(); }
    public static String email() { return faker.internet().emailAddress(); }
    public static String phoneNumber() { return faker.number().digits(10); }
    public static String streetAddress() { return faker.address().streetAddress(); }

    public static String gender() { return faker.options().option("Male", "Female", "Other"); }
    public static String subject() { return faker.options().option("Maths", "Physics", "Chemistry"); }
    public static String hobby() { return faker.options().option("Sports", "Reading", "Music"); }

    public static String month() {
        return faker.options().option(
                "January", "February", "March", "April", "May",
                "June", "July", "August", "September", "October",
                "November", "December"
        );
    }

    public static int day() { return faker.number().numberBetween(1, 28); }
    public static int year() { return faker.number().numberBetween(1990, 2010); }
}

