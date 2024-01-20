//package com.dollop.app.webSocketConfig;
//
//
//import java.io.IOException;
//import java.util.List;
//import java.util.concurrent.CopyOnWriteArrayList;
//
//import org.springframework.web.socket.CloseStatus;
//import org.springframework.web.socket.TextMessage;
//import org.springframework.web.socket.WebSocketSession;
//import org.springframework.web.socket.handler.TextWebSocketHandler;
//
//import com.dollop.app.entity.Comments;
//import com.google.gson.Gson;
//
//public class SocketHandler extends TextWebSocketHandler {
//    List<WebSocketSession> sessions = new CopyOnWriteArrayList<>();
//
//    @Override
//    public void handleTextMessage(WebSocketSession session, TextMessage message)
//            throws IOException {
//         System.err.println("---"+message.getPayload());
//        for (WebSocketSession webSocketSession : sessions) {
//            // Sends message to all sessions excepted himself
//            if (!session.equals(webSocketSession)) {
//            	System.err.println("sending message--"+message.getPayload());
//             //   Comments comment= new Gson().fromJson(message.getPayload(), Comments.class);
//                webSocketSession.sendMessage(new TextMessage((message.getPayload())));
//            }
//        }
//    }
//
//    @Override
//    public void afterConnectionEstablished(WebSocketSession session) {
//        // Will add the session to list -> to broadcast messages
//   
//    	System.err.println("session addes-----"+session);
//        sessions.add(session);
//    }
//
//    @Override
//    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) {
//        sessions.remove(session);
//    }
//}
