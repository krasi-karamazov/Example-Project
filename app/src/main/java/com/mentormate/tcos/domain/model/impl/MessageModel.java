package com.mentormate.tcos.domain.model.impl;

import com.mentormate.tcos.domain.model.base.BaseModel;

public class MessageModel implements BaseModel {

    private String message;

    public MessageModel(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
