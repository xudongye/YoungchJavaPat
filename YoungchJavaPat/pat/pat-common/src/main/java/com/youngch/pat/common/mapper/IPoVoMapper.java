package com.youngch.pat.common.mapper;


public interface IPoVoMapper<S,T> {

    /***
     * Each customized mapper must implements how to map an source object
     * @param sourceItem
     * @return
     */
    public abstract T map(S sourceItem);
}
