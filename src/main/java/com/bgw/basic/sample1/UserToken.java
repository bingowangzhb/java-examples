package com.bgw.basic.sample1;

/**
 * UserToken
 *
 * @author zhibin.wang
 * @since 2019-11-21 09:47
 **/
public class UserToken implements HostToken, RememberToken {

    @Override
    public String getHost() {
        return null;
    }

    @Override
    public void rememberMe() {

    }

    @Override
    public Object getPrincipal() {
        return null;
    }

    @Override
    public Object getCredentials() {
        return null;
    }
}
