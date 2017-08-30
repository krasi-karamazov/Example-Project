package com.mentormate.tcos.domain.model.impl;

import com.mentormate.tcos.domain.model.base.BaseModel;

import java.io.Serializable;

public class LoginModel implements BaseModel, Serializable {
    String access_token;
    String token_type;
    int expires_in;


    public LoginModel(String session, int expires_in, String token_type) {
        this.access_token = session;
        this.expires_in = expires_in;
        this.token_type = token_type;
    }

    public String getAccessToken() {
        return access_token;
    }

    public int getExpiresIn() {
        return expires_in;
    }

    public String getTokenType() {
        return token_type;
    }
}
