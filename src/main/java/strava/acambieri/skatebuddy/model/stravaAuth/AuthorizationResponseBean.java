package strava.acambieri.skatebuddy.model.stravaAuth;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.Instant;
import java.time.LocalDateTime;

public class AuthorizationResponseBean {
    @JsonProperty("token_type")
    private String token_type;
    @JsonProperty("access_token")
    private String access_token;
    @JsonProperty("athlete")
    private Athlete athlete;
    @JsonProperty("refresh_token")
    private String refresh_token;
    @JsonProperty("expires_at")
    private Instant expires_at;

    public String getToken_type() {
        return token_type;
    }

    public void setToken_type(String token_type) {
        this.token_type = token_type;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public Athlete getAthlete() {
        return athlete;
    }

    public void setAthlete(Athlete athlete) {
        this.athlete = athlete;
    }

    public String getRefresh_token() {
        return refresh_token;
    }

    public void setRefresh_token(String refresh_token) {
        this.refresh_token = refresh_token;
    }

    public Instant getExpires_at() {
        return expires_at;
    }

    public void setExpires_at(Instant expires_at) {
        this.expires_at = expires_at;
    }
}
