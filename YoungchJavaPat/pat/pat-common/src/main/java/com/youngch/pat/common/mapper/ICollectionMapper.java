package com.youngch.pat.common.mapper;

import java.util.List;


public interface ICollectionMapper<S,T> {

    /***
     * ICollection Mappper method
     * @param sourceItemList
     * @param targetItemsClass
     * @return
     */
    List<T> map(List<S> sourceItemList, Class<T> targetItemsClass);
}
