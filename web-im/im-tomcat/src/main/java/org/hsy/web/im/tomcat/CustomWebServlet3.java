package org.hsy.web.im.tomcat;

import org.java_websocket.WebSocket;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.drafts.Draft_6455;
import org.java_websocket.handshake.ServerHandshake;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.nio.ByteBuffer;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

/**
 * @author heshiyuan
 * @date 2021/9/2 19:45
 */
@WebServlet("/3")
public class CustomWebServlet3 extends HttpServlet {
    Logger logger = Logger.getLogger(CustomWebServlet3.class.getName());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        logger.info("HttpServlet doGet");
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        logger.info("HttpServlet doPost");
        String msg = req.getParameter("msg");
        /*WebSocketClient client = new WebSocketClient(new URI("ws://localhost:8080/tomcat/websocket/webSocketByTomcat/111"), new Draft_6455()) {

            @Override
            public void onOpen(ServerHandshake arg0) {
                System.out.println("打开链接");
            }

            @Override
            public void onMessage(String arg0) {
                System.out.println("收到消息" + arg0);
            }

            @Override
            public void onError(Exception arg0) {
                arg0.printStackTrace();
                System.out.println("发生错误已关闭");
            }

            @Override
            public void onClose(int arg0, String arg1, boolean arg2) {
                System.out.println("链接已关闭");
            }

            @Override
            public void onMessage(ByteBuffer bytes) {
                try {
                    System.out.println(new String(bytes.array(), "utf-8"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
        };

        client.connect();

        while(!client.getReadyState().equals(WebSocket.READYSTATE.OPEN)){
            System.out.println("还没有打开");
        }
        System.out.println("打开了");
        client.send(msg);*/
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
