package com.linesum.example.shiro;

import lombok.extern.log4j.Log4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * DESCRIPTION
 *
 * @author wdongsen@linesum.com
 * @data 2017-07-25 10:18
 */
@RunWith(SpringJUnit4ClassRunner.class)
@Log4j
public class ShiroLearningTestCase {

    @Test
    public void testHelloWorld(){
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");

        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);

        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = null;
        try {
            token = new UsernamePasswordToken("zhang", "1234");
        }catch (AuthenticationException e){
            log.error("验证失败");
        }

        subject.login(token);

        Assert.assertEquals(true, subject.isAuthenticated());
        subject.logout();
    }

    @Test
    public void testMyRealm(){
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro-realm.ini");

        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);

        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = null;
        try {
            token = new UsernamePasswordToken("zhang", "123");
        }catch (AuthenticationException e){
            log.error("验证失败");
        }

        subject.login(token);

        Assert.assertEquals(true, subject.isAuthenticated());
        subject.logout();
    }

    @Test
    public void testJdbcRealm(){
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro-jdbc-realm.ini");

        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);

        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = null;
        try {
            token = new UsernamePasswordToken("zhang", "123");
        }catch (AuthenticationException e){
            log.error("验证失败");
        }

        subject.login(token);

        Assert.assertEquals(true, subject.isAuthenticated());
        subject.logout();
    }

}
