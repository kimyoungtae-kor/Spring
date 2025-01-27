package shop.youngatae.socket.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import shop.youngatae.socket.handler.MessageHandler;


@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer{
    @Override
  public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
    registry.addHandler(chatHandler(), "/chat").setAllowedOriginPatterns("*").addHandler(chatHandler(), "/notic").setAllowedOriginPatterns("*");
  }

  @Bean
  public MessageHandler chatHandler() {
    return new MessageHandler();
  }
  @Bean
  public MessageHandler noticeHandler() {
      return new MessageHandler();
  }
}