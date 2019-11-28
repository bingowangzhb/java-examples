package com.bgw.basic.sample1;

import java.io.Serializable;

/**
 * AuthToken
 *
 * @author zhibin.wang
 * @since 2019-11-21 09:48
 **/
public interface AuthToken extends Serializable {
    Object getPrincipal();

    Object getCredentials();
}
