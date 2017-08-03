package com.linesum.example.shiro.realm;

import org.apache.shiro.authc.*;
import org.apache.shiro.realm.Realm;

import java.util.Objects;

/**
 * DESCRIPTION
 *
 * @author wdongsen@linesum.com
 * @data 2017-07-25 10:39
 */
public class MyRealm implements Realm{
    @Override
    public String getName() {
        return "MyRealm";
    }

    @Override
    public boolean supports(AuthenticationToken authenticationToken) {
        return authenticationToken instanceof UsernamePasswordToken;
    }

    @Override
    public AuthenticationInfo getAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String userName = (String) authenticationToken.getPrincipal();
        String password = new String((char[])authenticationToken.getCredentials());
        if(!Objects.equals("zhang", userName)){
            throw new UnknownAccountException();
        }
        if(!Objects.equals("123", password)){
            throw new IncorrectCredentialsException();
        }
        return new SimpleAuthenticationInfo(userName, password, getName());
    }
}
