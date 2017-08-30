package com.mentormate.tcos.treading;

import com.mentormate.tcos.threading.base.MainThread;

public class TestMainThread implements MainThread {

    @Override
    public void post(Runnable runnable) {
        // tests can run on this thread, no need to invoke other threads
        runnable.run();
    }
}
