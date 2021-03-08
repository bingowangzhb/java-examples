package com.bgw.tomcat;

import org.apache.catalina.Wrapper;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;


/**
 * TomcatTest
 *
 * @author zhibin.wang
 * @since 2021/01/16 15:35
 */
public class TomcatTest {

    public static void main(String[] args) {

        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);
        tomcat.setBaseDir(System.getProperty("user.dir"));

        StandardContext context = new StandardContext();
        context.setDocBase((System.getProperty("user.dir") + "\\src\\main\\resources\\static").replace("\\", "/"));
        context.setPath("/my");
        context.addLifecycleListener(new Tomcat.FixContextListener());

        tomcat.getHost().addChild(context);
        Wrapper wrapper = context.createWrapper();


        tomcat.getServer().await();

    }
}
