package com.mentormate.tcos.domain.repository.impl;

import com.mentormate.tcos.domain.model.impl.LoginModel;
import com.mentormate.tcos.domain.repository.Repository;

public class LoginRepository implements Repository<LoginModel> {


    @Override
    public boolean insert(LoginModel model) {
        return false;
    }

    @Override
    public boolean update(LoginModel model) {
        return false;
    }

    @Override
    public LoginModel get(long id) {
        String msg = "123456";

        // simulate some network/database lag
        //        try {
        //            Thread.sleep(2000);
        //        } catch (InterruptedException e) {
        //            e.printStackTrace();
        //        }

        return new LoginModel(msg, 1, msg);
    }

    @Override
    public boolean delete(LoginModel model) {
        return false;
    }
}
