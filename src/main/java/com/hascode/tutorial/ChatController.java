package com.hascode.tutorial;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;

public class ChatController implements Initializable {
	@FXML
	private MenuItem exitItem;

	@Override
	public void initialize(final URL url, final ResourceBundle bundle) {
		exitItem.setOnAction(e -> System.exit(0));
	}

}
