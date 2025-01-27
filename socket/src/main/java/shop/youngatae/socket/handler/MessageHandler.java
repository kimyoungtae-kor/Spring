package shop.youngatae.socket.handler;

import java.util.concurrent.CopyOnWriteArraySet;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class MessageHandler extends TextWebSocketHandler{
private CopyOnWriteArraySet<WebSocketSession> sessions = new CopyOnWriteArraySet<>();
  
  @Override
  public void afterConnectionEstablished(WebSocketSession session) throws Exception {
    sessions.add(session);
    log.info(session);
  }

  @Override
  protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
    for(WebSocketSession ws : sessions){
      log.info(message.getPayload());
      ws.sendMessage(new TextMessage(message.getPayload()));
    }
  }

  @Override
  public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
    sessions.remove(session);
  }

  
}