package data;

import utils.FakerGenerator;

public class TestData {

    public final String firstName = FakerGenerator.firstName();
    public final String lastName = FakerGenerator.lastName();
    public final String userEmail = FakerGenerator.email();
    public final String phoneNumber = FakerGenerator.phoneNumber();
    public final String streetAddress = FakerGenerator.streetAddress();
    public final String gender = FakerGenerator.gender();
    public final String subject = FakerGenerator.subject();
    public final String hobby = FakerGenerator.hobby();

    public final String month = FakerGenerator.month();
    public final int day = FakerGenerator.day();
    public final int year = FakerGenerator.year();

    public final String state = "NCR";
    public final String city = "Delhi";
}
