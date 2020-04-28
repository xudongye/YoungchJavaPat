package com.youngch.pat.common.decorate;

import java.util.List;


public interface ICollectionDecorator<T> {

    /***
     * ICollection Mappper method
     * @param sourceItemList
     * @return
     */
    List<T> decorate(List<T> sourceItemList);
}
