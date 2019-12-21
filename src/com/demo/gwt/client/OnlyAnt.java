package com.demo.gwt.client;

import com.demo.gwt.shared.FieldVerifier;
import com.google.gwt.user.client.rpc.ServiceDefTarget;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class OnlyAnt implements EntryPoint {
	/**
	 * The message displayed to the user when the server cannot be reached or
	 * returns an error.
	 */
	private static final String SERVER_ERROR = "An error occurred while "
			+ "attempting to contact the server. Please check your network " + "connection and try again.";

	/**
	 * Create a remote service proxy to talk to the server-side Greeting service.
	 */
	
	GreetingServiceAsync greetingService = (GreetingServiceAsync)GWT.create(GreetingService.class);
	
	GreetingService1Async greetingService1 = (GreetingService1Async)GWT.create(GreetingService1.class);
	

//	private final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
//		((ServiceDefTarget)greetingService)
//		   .setServiceEntryPoint("http://127.0.0.1:8888/onlyant/greet");
		
		
		
		final Button sendButton = new Button("Send");
		final TextBox nameField = new TextBox();
		nameField.setText("GWT User");
		final Label errorLabel = new Label();

		// We can add style names to widgets
		sendButton.addStyleName("sendButton");

		// Add the nameField and sendButton to the RootPanel
		// Use RootPanel.get() to get the entire body element
		RootPanel.get("nameFieldContainer").add(nameField);
		RootPanel.get("sendButtonContainer").add(sendButton);
		RootPanel.get("errorLabelContainer").add(errorLabel);

		// Focus the cursor on the name field when the app loads
		nameField.setFocus(true);
		nameField.selectAll();
		// Create the popup dialog box
		final DialogBox dialogBox = new DialogBox();
		dialogBox.setText("Remote Procedure Call");
		dialogBox.setAnimationEnabled(true);
		final Button closeButton = new Button("Close");
		// We can set the id of a widget by accessing its Element
		closeButton.getElement().setId("closeButton");
		final Label textToServerLabel = new Label();
		final HTML serverResponseLabel = new HTML();
		VerticalPanel dialogVPanel = new VerticalPanel();
		dialogVPanel.addStyleName("dialogVPanel");
		dialogVPanel.add(new HTML("<b>Sending name to the server:</b>"));
		dialogVPanel.add(textToServerLabel);
		dialogVPanel.add(new HTML("<br><b>Server replies:</b>"));
		dialogVPanel.add(serverResponseLabel);
		dialogVPanel.setHorizontalAlignment(VerticalPanel.ALIGN_RIGHT);
		dialogVPanel.add(closeButton);
		dialogBox.setWidget(dialogVPanel);

		// Add a handler to close the DialogBox
		closeButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				dialogBox.hide();
				sendButton.setEnabled(true);
				sendButton.setFocus(true);
			}
		});

		// Create a handler for the sendButton and nameField
		class MyHandler implements ClickHandler, KeyUpHandler {
			/**
			 * Fired when the user clicks on the sendButton.
			 */
			public void onClick(ClickEvent event) {
				sendNameToServer();
			}

			/**
			 * Fired when the user types in the nameField.
			 */
			public void onKeyUp(KeyUpEvent event) {
				if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
					sendNameToServer();
				}
			}

			/**
			 * Send the name from the nameField to the server and wait for a response.
			 */
			private void sendNameToServer() {
				// First, we validate the input.
				errorLabel.setText("");
				String textToServer = nameField.getText();
				if (!FieldVerifier.isValidName(textToServer)) {
					errorLabel.setText("Please enter at least four characters");
					return;
				}

				// Then, we send the input to the server.
				sendButton.setEnabled(false);
				textToServerLabel.setText(textToServer);
				serverResponseLabel.setText("");
				greetingService.greetServer(textToServer, new AsyncCallback<String>() {
					public void onFailure(Throwable caught) {
						// Show the RPC error message to the user
						dialogBox.setText("Remote Procedure Call - Failure");
						serverResponseLabel.addStyleName("serverResponseLabelError");
						serverResponseLabel.setHTML(SERVER_ERROR);
						dialogBox.center();
						closeButton.setFocus(true);
					}

					public void onSuccess(String result) {
						dialogBox.setText("Remote Procedure Call");
						serverResponseLabel.removeStyleName("serverResponseLabelError");
						serverResponseLabel.setHTML(result);
						dialogBox.center();
						closeButton.setFocus(true);
					}
				});
			}
		}
		
		
		
		
		//////		//////		//////		//////		//////		//////		//////
		
		
		
		
		
		
		
		
		final Button sendButton1 = new Button("Send");
		final TextBox nameField1 = new TextBox();
		nameField1.setText("GWT User");
		final Label errorLabel1 = new Label();

		// We can add style names to widgets
		sendButton1.addStyleName("sendButton");

		// Add the nameField and sendButton to the RootPanel
		// Use RootPanel.get() to get the entire body element
		RootPanel.get("nameFieldContainer").add(nameField1);
		RootPanel.get("sendButtonContainer").add(sendButton1);
		RootPanel.get("errorLabelContainer").add(errorLabel1);
		
//		nameField1.setFocus(true);
//		nameField1.selectAll();
		
		
		
		
		
		
		final DialogBox dialogBox1 = new DialogBox();
		dialogBox1.setText("Remote Procedure Call1");
		dialogBox1.setAnimationEnabled(true);
		final Button closeButton1 = new Button("Close");
		// We can set the id of a widget by accessing its Element
		closeButton1.getElement().setId("closeButton");
		final Label textToServerLabel1 = new Label();
		final HTML serverResponseLabel1 = new HTML();
		VerticalPanel dialogVPanel1 = new VerticalPanel();
		dialogVPanel1.addStyleName("dialogVPanel");
		dialogVPanel1.add(new HTML("<b>Sending name to the server:</b>"));
		dialogVPanel1.add(textToServerLabel1);
		dialogVPanel1.add(new HTML("<br><b>Server replies:</b>"));
		dialogVPanel1.add(serverResponseLabel1);
		dialogVPanel1.setHorizontalAlignment(VerticalPanel.ALIGN_RIGHT);
		dialogVPanel1.add(closeButton1);
		dialogBox1.setWidget(dialogVPanel1);

		// Add a handler to close the DialogBox
		closeButton1.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				dialogBox1.hide();
				sendButton1.setEnabled(true);
				sendButton1.setFocus(true);
			}
		});


		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		// Create a handler for the sendButton and nameField
		class MyHandler1 implements ClickHandler, KeyUpHandler {
			/**
			 * Fired when the user clicks on the sendButton.
			 */
			public void onClick(ClickEvent event) {
				sendNameToServer1();
			}
	
			/**
			 * Fired when the user types in the nameField.
			 */
			public void onKeyUp(KeyUpEvent event) {
				if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
					sendNameToServer1();
				}
			}
	
			/**
			 * Send the name from the nameField to the server and wait for a response.
			 */
			private void sendNameToServer1() {
				// First, we validate the input.
				errorLabel1.setText("");
				String textToServer1 = nameField1.getText();
				if (!FieldVerifier.isValidName(textToServer1)) {
					errorLabel1.setText("Please enter at least four characters");
					return;
				}
	
				// Then, we send the input to the server.
				sendButton1.setEnabled(false);
				textToServerLabel.setText(textToServer1);
				serverResponseLabel1.setText("");
				greetingService1.greetServer1(textToServer1, new AsyncCallback<String>() {
					public void onFailure(Throwable caught) {
						// Show the RPC error message to the user
						dialogBox1.setText("Remote Procedure Call - Failure");
						serverResponseLabel1.addStyleName("serverResponseLabelError");
						serverResponseLabel1.setHTML(SERVER_ERROR);
						dialogBox1.center();
						closeButton1.setFocus(true);
					}
	
					public void onSuccess(String result) {
						dialogBox1.setText("Remote Procedure Call1");
						serverResponseLabel1.removeStyleName("serverResponseLabelError");
						serverResponseLabel1.setHTML(result);
						dialogBox1.center();
						closeButton1.setFocus(true);
					}
				});
			}
		}
				
				
				
				
				
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		MyHandler1 handler1 = new MyHandler1();
		sendButton1.addClickHandler(handler1);
		nameField1.addKeyUpHandler(handler1);
		
		
		
		
		
		
		
		
		
		
		
		
		
		// Add a handler to send the name to the server
		MyHandler handler = new MyHandler();
		sendButton.addClickHandler(handler);
		nameField.addKeyUpHandler(handler);
		
		
		
	}
}
