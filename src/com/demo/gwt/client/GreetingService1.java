package com.demo.gwt.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client-side stub for the RPC service.
 */
@RemoteServiceRelativePath("greet1")
public interface GreetingService1 extends RemoteService {
	String greetServer1(String name) throws IllegalArgumentException;
}
