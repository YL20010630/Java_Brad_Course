package webSocket;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;

import jakarta.websocket.OnClose;
import jakarta.websocket.OnError;
import jakarta.websocket.OnMessage;
import jakarta.websocket.OnOpen;
import jakarta.websocket.Session;
import jakarta.websocket.server.ServerEndpoint;

//	連線到 MyClient.html、myjs.js
//	MyServer.java：WebSocket 伺服器，廣播所有訊息給大家
//	每當有前端送來訊息，就直接轉送給所有人
//	沒有身分判斷，誰都可以送出與收到

@ServerEndpoint("/myserver")
public class MyServer {
	
//	static 表示：大家共用一份 sessions，才能共享「所有人」的連線狀態
//	sessions：所有連線中使用者清單（用來廣播）
//	users：存每個使用者對應的連線（用來找特定人）

	private static HashSet<Session> sessions;
	private static HashMap<String, Session> users;
	
	public MyServer() {
		System.out.println("MyServer()");
		if (sessions == null) {
			sessions = new HashSet<Session>();
			users = new HashMap<String, Session>();
		}
	}
	
	@OnOpen
	public void onOpen(Session session) {
		System.out.println("OnOpen");
		
		if (sessions.add(session)) {
			users.put(session.getId(), session);
			System.out.println("count:" + sessions.size());
		}
	}
	
	@OnMessage
	public void onMessage(String mesg, Session session) {
		System.out.println("OnMessage:" + mesg);
		for(Session userSession : sessions) {
			try {
//				讓伺服器傳送文字訊息給一個特定的使用者（session）
				userSession.getBasicRemote().sendText(mesg);
//				.getBasicRemote()取得這個使用者連線的遠端介面，可以透過它發送訊息
			} catch (IOException e) {
				System.err.println(e);
			}
		}
		
	}
	
	@OnClose
	public void onClose(Session session) {
		System.out.println("OnClose");
		users.remove(session.getId());
		sessions.remove(session);
		System.out.println("count:" + sessions.size());
	}
	
	@OnError
	public void onError(Session session, Throwable t) {
		System.out.println("OnError:" + t.toString());
	}
}