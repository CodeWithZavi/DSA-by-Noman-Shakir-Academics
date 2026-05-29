/*
 * Author: NOMAN SHAKIR
 */
package com.dsa.core;

public class SpotifyConfig {
    public static final String CLIENT_ID = env("SPOTIFY_CLIENT_ID");
    public static final String CLIENT_SECRET = env("SPOTIFY_CLIENT_SECRET");

    public static final String REDIRECT_URI = "http://127.0.0.1:8888/callback";
    public static final String AUTH_URL = "https://accounts.spotify.com/authorize";
    public static final String TOKEN_URL = "https://accounts.spotify.com/api/token";
    public static final String API_BASE = "https://api.spotify.com/v1";

    public static boolean isSpotifyConfigured() {
        return !CLIENT_ID.isBlank() && !CLIENT_SECRET.isBlank();
    }

    private static String env(String key) {
        String value = System.getenv(key);
        return value == null ? "" : value.trim();
    }
}
