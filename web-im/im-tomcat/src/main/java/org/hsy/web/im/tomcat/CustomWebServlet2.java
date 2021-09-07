package org.hsy.web.im.tomcat;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.util.logging.Logger;

/**
 * @author heshiyuan
 * @date 2021/9/2 19:45
 */
@WebServlet(urlPatterns = {"/2/**"})
public class CustomWebServlet2 extends GenericServlet {
    Logger logger = Logger.getLogger(CustomWebServlet2.class.getName());

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        logger.info("GenericServlet service");
    }
}
