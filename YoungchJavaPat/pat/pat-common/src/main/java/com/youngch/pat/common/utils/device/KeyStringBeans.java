package com.youngch.pat.common.utils.device;

import java.io.Serializable;
import java.util.List;

/**
 * Created by ZhangHs on 2018/12/25.
 */

public class KeyStringBeans implements Serializable {
    private List<String> keys;

    public List<String> getKeys() {
        return keys;
    }

    public void setKeys(List<String> keys) {
        this.keys = keys;
    }
}
