package com.mentormate.tcos.domain.interactors.base;


/**
 * This is the interface for interactors. Every interactor is used for a specific use case
 */

public interface Interactor {

    /**
     * Method which starts the interactor. The operation executed here will be done on a background thread
     */

    void execute();
}
