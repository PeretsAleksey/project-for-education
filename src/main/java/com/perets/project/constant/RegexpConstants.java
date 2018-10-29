package com.perets.project.constant;

public class RegexpConstants {

    public static final String SEARCH_QUERY_LATIN_MAX_35_OR_EMPTY = "[\\S-'_ ]{2,35}|";
    public static final String UUID_ID = "[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}";

    private RegexpConstants() {
        throw new UnsupportedOperationException();
    }
}
