package com.youngch.pat.pay.service;


import com.youngch.pat.pay.business.NotifyBusinessBo;

/**
 * @author whitestone
 */
public interface NotifyBusinessBoFactory {

    /**
     * get Notify Bo used by notification
     */
    NotifyBusinessBo getNotifyBusinessBo();
}
