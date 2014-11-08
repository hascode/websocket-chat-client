package com.hascode.tutorial;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.SceneBuilder;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

@SuppressWarnings("deprecation")
public class GuiChatClient extends Application {
	private static final String VIEW_GAME = "/template/chat.fxml";

	@Override
	public void start(final Stage stage) throws Exception {
		initGui(stage);
	}

	private void initGui(final Stage stage) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource(VIEW_GAME));
		Scene scene = SceneBuilder.create().root(root).fill(Color.GRAY).build();
		stage.setScene(scene);
		stage.setTitle("hasCode.com - Websocket Chat Client");
		stage.show();
	}

	public static void main(final String... args) {
		Application.launch(args);
	}

}
