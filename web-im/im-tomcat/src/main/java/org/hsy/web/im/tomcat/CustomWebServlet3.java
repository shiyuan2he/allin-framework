package org.hsy.web.im.tomcat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

/**
 * @author heshiyuan
 * @date 2021/9/2 19:45
 */
@WebServlet(urlPatterns = {"/3/**"})
public class CustomWebServlet3 extends HttpServlet {
    Logger logger = Logger.getLogger(CustomWebServlet3.class.getName());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        logger.info("HttpServlet doGet");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        logger.info("HttpServlet doPost");
    }
    public void output(HttpServletRequest req, HttpServletResponse resp){
        resp.setContentType("text/html");
        PrintWriter out = null;
        try {
            out = resp.getWriter();
            for (int i = 1; i <= 10; i++) {
                TimeUnit.SECONDS.sleep(3);
                out.print("嘿嘿嘿 " + i) ;
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        out.flush();
        out.close();
    }
}
