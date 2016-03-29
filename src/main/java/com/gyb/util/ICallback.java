package com.gyb.util;

import org.hibernate.Session;

public interface ICallback {	 
	
	void Exec(Session session);
}


