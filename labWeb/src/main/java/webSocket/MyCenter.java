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

//	跟MyClient.html、teacher、student、MyCenter.java

@ServerEndpoint("/mycenter")
public class MyCenter {
	private static HashSet<Session> sessions;
	private static HashMap<String, Session> users;
	private static boolean isExistTeacher = false;
	private static Session teacherSession;
	
	public MyCenter() {
		System.out.println("MyCenter()");
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
		
//		判斷目前還沒有「老師」的連線，且收到的訊息字串中包含 isTeacher 這個標記（代表這個連線是老師端）。
		if (!isExistTeacher && mesg.contains("isTeacher")) {
//			設定「老師已存在」狀態為真
			isExistTeacher = true;
//			並且把這個連線（Session）記錄成 teacherSession
			teacherSession = session;
		}
		
//		只有當老師已存在，且訊息是由老師這個連線傳來，才進行廣播
		if (isExistTeacher && session == teacherSession) {
//			把所有連線（包含老師自己和其他使用者）都一一取出
			for(Session userSession : sessions) {
				try {
//					將收到的訊息，送給每一個連線的使用者
					userSession.getBasicRemote().sendText(mesg);
				} catch (IOException e) {
					System.err.println(e);
				}
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