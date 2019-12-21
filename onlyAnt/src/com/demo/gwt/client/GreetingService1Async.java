package com.demo.gwt.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface GreetingService1Async {
	void greetServer1(String input, AsyncCallback<String> callback) throws IllegalArgumentException;
}
