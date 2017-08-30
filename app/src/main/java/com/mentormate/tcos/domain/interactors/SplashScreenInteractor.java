package com.mentormate.tcos.domain.interactors;

import com.mentormate.tcos.network.model.DiscoveryResponseModel;

public interface SplashScreenInteractor {
    interface Callback {
        void onSuccess(DiscoveryResponseModel model);

        void onError();
    }
}
