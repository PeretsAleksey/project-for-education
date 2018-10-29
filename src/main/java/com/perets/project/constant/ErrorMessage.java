package com.perets.project.constant;

public class ErrorMessage {

    public static final String SEARCH_QUERY = "Incorrect search query. Min length is 2 chars. Max length is 35 chars.";
    public static final String INCORRECT_USER_ID = "Incorrect user id";
    public static final String USER_ALREADY_EXISTS = "User already exists";
    public static final String USER_DOES_NOT_EXIST = "User does not exist";
    public static final String INCORRECT_USER_NAME_OR_EMAIL = "Incorrect user name or email";

    private ErrorMessage() {
        throw new UnsupportedOperationException();
    }
}
