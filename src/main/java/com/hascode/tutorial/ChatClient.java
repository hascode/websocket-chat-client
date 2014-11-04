package com.hascode.tutorial;

import java.net.URI;
import java.net.URISyntaxException;

import javax.json.Json;

public class ChatClient {
	public static void main(final String[] args) throws InterruptedException, URISyntaxException {
		System.out.println("starting chat");
		final ChatClientEndpoint clientEndPoint = new ChatClientEndpoint(new URI("ws://0.0.0.0:8080/hascode/chat/java"));
		clientEndPoint.addMessageHandler(message -> {
			System.out.println("Message received: " + message);
			clientEndPoint.sendMessage("How are you?");
		});

		while (true) {
			String user = "fred";
			String message = "hey there";
			clientEndPoint.sendMessage(createJsonMessage(user, message));
			Thread.sleep(30000);
		}
	}

	private static String createJsonMessage(final String user, final String message) {
		return Json.createObjectBuilder().add("sender", user).add("message", message).build().toString();
	}

}
