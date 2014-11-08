package com.hascode.tutorial.gui;

import java.io.StringReader;
import java.net.URI;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;

import javax.json.Json;
import javax.json.JsonObject;

import com.hascode.tutorial.ChatClientEndpoint;

public class ChatController implements Initializable {
	@FXML
	private MenuItem exitItem;

	@FXML
	private ChoiceBox<String> roomSelection;

	@FXML
	private Button connectButton;

	@FXML
	private TextField userNameTextfield;

	@FXML
	private TextField messageTextField;

	@FXML
	private Button chatButton;

	private final ChatModel model = new ChatModel();

	private ChatClientEndpoint clientEndPoint;

	@Override
	public void initialize(final URL url, final ResourceBundle bundle) {
		exitItem.setOnAction(e -> Platform.exit());
		roomSelection.setItems(FXCollections.observableArrayList("arduino", "java", "groovy", "scala"));
		roomSelection.getSelectionModel().select(1);
		model.readyToChat.bind(userNameTextfield.textProperty().isNotEmpty().and(roomSelection.selectionModelProperty().isNotNull()));
		chatButton.disableProperty().bind(model.connected.not());
		messageTextField.disableProperty().bind(model.connected.not());
		connectButton.disableProperty().bind(model.readyToChat.not());
		chatButton.setOnAction(evt -> {
			clientEndPoint.sendMessage(stringToJsonMessage(userNameTextfield.getText(), messageTextField.getText()));
		});
		connectButton.setOnAction(evt -> {
			try {
				final String roomName = roomSelection.getSelectionModel().getSelectedItem();

				clientEndPoint = new ChatClientEndpoint(new URI("ws://0.0.0.0:8080/hascode/chat/" + roomName));
				clientEndPoint.addMessageHandler(responseString -> {
					System.out.println(jsonMessageToString(responseString, roomName));
				});
				model.connected.set(true);
			} catch (Exception e) {
				e.printStackTrace();
			}

		});
	}

	private static String stringToJsonMessage(final String user, final String message) {
		return Json.createObjectBuilder().add("sender", user).add("message", message).build().toString();
	}

	private static String jsonMessageToString(final String response, final String roomName) {
		JsonObject root = Json.createReader(new StringReader(response)).readObject();
		String message = root.getString("message");
		String sender = root.getString("sender");
		String received = root.getString("received");
		return String.format("%s@%s: %s [%s]", sender, roomName, message, received);
	}

}
