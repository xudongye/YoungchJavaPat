package com.youngch.pat.common.decorate;


public interface IVoDecorator<T>{

    /***
     * Each customized decorator must implements how to decorate an source object
     * @param sourceItem
     * @return
     */
    public abstract T decorate(T sourceItem);
}
