package com.perets.project.constant;

public class ErrorMessage {

    public static final String SEARCH_QUERY = "Incorrect search query. Min length is 2 chars. Max length is 35 chars.";
    public static final String USER_ALREADY_EXISTS = "User already exists";
    public static final String USER_WITH_SPECIFIED_ID_DOES_NOT_EXIST = "User with specified id does not exist";
    public static final String THERE_ARE_NOT_USERS_WITH_SUCH_PARAMETERS = "There are no users with such parameters";

    private ErrorMessage() {
        throw new UnsupportedOperationException();
    }
}
