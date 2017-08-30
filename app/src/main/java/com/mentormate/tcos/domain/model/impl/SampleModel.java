package com.mentormate.tcos.domain.model.impl;

import com.mentormate.tcos.domain.model.base.BaseModel;

public class SampleModel implements BaseModel {
    private int val;

    public SampleModel(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }
}
