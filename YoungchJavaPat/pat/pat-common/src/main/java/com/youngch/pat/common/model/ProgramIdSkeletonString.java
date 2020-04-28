package com.youngch.pat.common.model;

/**
 * @author yexudong
 * @date 2018/5/15 12:32
 */
public class ProgramIdSkeletonString {
    private String pgmId;

    public String getPgmId() {
        return pgmId;
    }

    public void setPgmId(String pgmId) {
        this.pgmId = pgmId;
    }

    @Override
    public String toString() {
        return "ProgramIdSkeletonString{" +
                "pgmId='" + pgmId + '\'' +
                '}';
    }
}
