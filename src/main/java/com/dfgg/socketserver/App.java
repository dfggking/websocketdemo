package com.dfgg.socketserver;

import com.corundumstudio.socketio.Configuration;
import com.corundumstudio.socketio.SocketIOServer;

/**
 * @Description TODO
 * @author jinyf@hollysos.com
 * @date 2017-06-16 11:34:10
 * @version 
 */
public class App {

	
	/**
	 * @Description TODO
	 * @author jinyf@hollysos.com
	 * @date 2017-06-16 11:34:10
	 * @param 
	 * @return void
	 * @version 
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		Configuration config = new Configuration();
		config.setHostname("localhost");
		config.setPort(8080);
		
		SocketIOServer server = new SocketIOServer(config);
		SocketServerListener listener = new SocketServerListener();
		listener.setServer(server);
		// chatEvent 为事件名称
		server.addEventListener("chatevent", ChatObj.class, listener);
		
		// 启动服务
		server.start();
		Thread.sleep(Integer.MAX_VALUE);
		server.stop();
	}

}




