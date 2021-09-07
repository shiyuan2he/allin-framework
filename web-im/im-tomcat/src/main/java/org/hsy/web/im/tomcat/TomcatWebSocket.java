package org.hsy.web.im.tomcat;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Logger;

/**
 * @author heshiyuan
 * @date 2021/9/6 11:50
 */
@ServerEndpoint("/websocket/webSocketByTomcat/{sessionId}")
public class TomcatWebSocket {
    Logger logger = Logger.getLogger(TomcatWebSocket.class.getName());
    private static int onlineCount = 0;
    private static Map<String, TomcatWebSocket> clients = new ConcurrentHashMap<>();
    private Session session;
    private String sessionId;

    @OnOpen
    public void onOpen(@PathParam("sessionId") String sessionId, Session session) throws IOException {
        this.sessionId = sessionId;
        this.session = session;

        addOnlineCount();
        clients.put(sessionId, this);
        logger.info(sessionId + " 已连接, 当前在线数量：" + onlineCount);
    }

    @OnClose
    public void onClose() throws IOException {
        clients.remove(sessionId);
        subOnlineCount();
        logger.info(sessionId + " 已离开, 当前在线数量：" + onlineCount);
    }

    @OnMessage
    public void onMessage(String message) throws IOException {
        logger.info(message);
        for (TomcatWebSocket item : clients.values()) {
            item.session.getAsyncRemote().sendText(message);
        }
    }

    @OnError
    public void onError(Session session, Throwable error) {
        logger.info(session.getId() + " 出错了， 错误信息是：" + error.getMessage());
    }

    public void sendMessageTo(String message, String To) throws IOException {
        for (TomcatWebSocket item : clients.values()) {
            if (item.sessionId.equals(To)) {
                item.session.getAsyncRemote().sendText(message);
            }
        }
    }

    public void sendMessageAll(String message) throws IOException {
        for (TomcatWebSocket item : clients.values()) {
            item.session.getAsyncRemote().sendText(message);
        }
    }



    public static synchronized int getOnlineCount() {
        return onlineCount;
    }

    public static synchronized void addOnlineCount() {
        TomcatWebSocket.onlineCount++;
    }

    public static synchronized void subOnlineCount() {
        TomcatWebSocket.onlineCount--;
    }

    public static synchronized Map<String, TomcatWebSocket> getClients() {
        return clients;
    }
}