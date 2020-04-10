package com.youngch.pat.beyond.scheduled;

public class ZhuzherResponseBean {
    private int type;
    private ZhuzherData data;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public ZhuzherData getData() {
        return data;
    }

    public void setData(ZhuzherData data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ZhuzherResponseBean{" +
                "type=" + type +
                ", data=" + data +
                '}';
    }
}
