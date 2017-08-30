package com.mentormate.tcos.domain.executor.base;

import com.mentormate.tcos.domain.interactors.base.AbstractInteractor;

/**
 * This object is responsible for running interactors on a background thread
 */

public interface Executor {

    /**
     *
     * @param interactor The interactor which tasks must be run
     */

    void execute(final AbstractInteractor interactor);
}
