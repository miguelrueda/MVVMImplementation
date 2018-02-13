package com.example.rxjavamvvm;

public interface IViewModel<M> {

    /**
     * Connect the "backend" models
     *
     * @param model
     */
    void connectTo(M model);

}
