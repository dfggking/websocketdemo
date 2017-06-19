package com.dfgg.socketserver;

import com.corundumstudio.socketio.AckRequest;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.listener.DataListener;

/**
 * @Description TODO
 * @author jinyf@hollysos.com
 * @date 2017-06-16 11:08:21
 * @version 
 */
public class SocketServerListener implements DataListener<ChatObj> {

	SocketIOServer server;
	
	/* (non-Javadoc)
	 * @see com.corundumstudio.socketio.listener.DataListener#onData(com.corundumstudio.socketio.SocketIOClient, java.lang.Object, com.corundumstudio.socketio.AckRequest)
	 * @Description TODO
	 * @author jinyf@hollysos.com
	 * @date 2017-06-16 11:31:59
	 * @version
	 */
	public void onData(SocketIOClient client, ChatObj data, AckRequest ackSender) throws Exception {
		
		System.out.println(data.getMessage());
		this.server.getBroadcastOperations().sendEvent("chatevent", data);
	}

	/**
	 * @return the server
	 */
	public SocketIOServer getServer() {
		return server;
	}

	/**
	 * @param server the server to set
	 */
	public void setServer(SocketIOServer server) {
		this.server = server;
	}

	
	
}
