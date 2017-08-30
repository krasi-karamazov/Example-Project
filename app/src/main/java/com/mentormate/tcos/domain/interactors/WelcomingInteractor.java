package com.mentormate.tcos.domain.interactors;

import com.mentormate.tcos.domain.interactors.base.Interactor;

public interface WelcomingInteractor {
    interface CallBack{
        void onMessageRetrieved(String message);
        void onMessageRetrievalFailed(String error);
    }
}
