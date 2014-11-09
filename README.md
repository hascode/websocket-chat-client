# Java Websocket Chat Client

An example of Java's websocket client API to connect to the chat server from my other tutorials "[Creating a Websocket Chat Application with Vert.x and Java]" or "[Creating a Chat Application using Java EE 7, Websockets and GlassFish 4]".

## Running the Chat Client

You may run the console or gui client the following way, precondition is an installed JDK8 and Maven..

### Console Client

You may either run the client using Maven's Exec Plugin:

   mvn exec:java -Dexec.mainClass=com.hascode.tutorial.console.ConsoleChatClient 


### JavaFX GUI Client

You may either run the client using Maven's Exec Plugin:

   mvn exec:java -Dexec.mainClass=com.hascode.tutorial.gui.GuiChatClient

Or simply package the application and run it with Java:

   mvn clean package && java -cp /data/project/java-websocket-chat-client/target/websocket-chat-client-1.0.0.jar com.hascode.tutorial.gui.GuiChatClient

----

**2014 Micha Kops / hasCode.com**


   [Creating a Websocket Chat Application with Vert.x and Java]:http://www.hascode.com/2013/11/creating-a-websocket-chat-application-with-vert-x-and-java/
   [Creating a Chat Application using Java EE 7, Websockets and GlassFish 4]:http://www.hascode.com/2013/08/creating-a-chat-application-using-java-ee-7-websockets-and-glassfish-4/
