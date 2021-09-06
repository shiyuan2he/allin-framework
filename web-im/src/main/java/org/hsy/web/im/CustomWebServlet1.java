package org.hsy.web.im;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.util.logging.Logger;

/**
 * @author heshiyuan
 * @date 2021/9/2 19:45
 */
@WebServlet(urlPatterns = {"/1/**"})
public class CustomWebServlet1 implements Servlet {
    Logger logger = Logger.getLogger(CustomWebServlet1.class.getName());
    @Override
    public void init(ServletConfig config) throws ServletException {
        logger.info("Servlet init");
    }

    @Override
    public ServletConfig getServletConfig() {
        logger.info("Servlet getServletConfig");
        return null;
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        logger.info("Servlet service");
    }

    @Override
    public String getServletInfo() {
        logger.info("Servlet getServletInfo");
        return null;
    }

    @Override
    public void destroy() {
        logger.info("Servlet destroy");
    }
}
