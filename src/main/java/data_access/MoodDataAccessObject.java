package data_access;

import use_case.data_access.MoodDataAccessInterface;

import java.net.http.HttpClient;

public class MoodDataAccessObject implements MoodDataAccessInterface {
    private final HttpClient client;
    private final ObjectMapper mapper;
    private final String supabaseUrl;

}
