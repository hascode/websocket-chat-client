package com.hascode.tutorial;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.GroupBuilder;
import javafx.scene.Scene;
import javafx.scene.SceneBuilder;
import javafx.scene.paint.Color;
import javafx.scene.text.TextBuilder;
import javafx.stage.Stage;

@SuppressWarnings("deprecation")
public class GuiChatClient extends Application {
	public static void main(final String... args) {
		Application.launch(args);
	}

	private final Group area = GroupBuilder.create().focusTraversable(true).children(TextBuilder.create().text("Fooo").build()).build();

	@Override
	public void start(final Stage stage) throws Exception {
		Scene scene = SceneBuilder.create().width(500).height(530).fill(Color.WHITE).root(area).build();
		stage.setScene(scene);
		stage.setTitle("hasCode.com - Websocket Chat");
		stage.show();
	}

}
