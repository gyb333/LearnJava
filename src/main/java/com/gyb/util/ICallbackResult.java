package com.gyb.util;

import org.hibernate.Session;

public interface ICallbackResult {
	Object ExecResult(Session session);
	
	 
}