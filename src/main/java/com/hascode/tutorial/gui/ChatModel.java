package com.hascode.tutorial.gui;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

public class ChatModel {
	public final BooleanProperty connected = new SimpleBooleanProperty(false);
	public final BooleanProperty readyToChat = new SimpleBooleanProperty(false);
}
