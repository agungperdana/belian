package com.kratonsolution.belian.camel;

import java.util.HashMap;
import java.util.Map;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 2.0.0
 */
public class AccessDeniedErrorHandler implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {

		Map<String, String> map = new HashMap<>();
		map.put("status", "false");
		map.put("message", "Access Denied: You don't have permissions !");
		
		exchange.getMessage().setBody(map);
		exchange.getMessage().setHeader(Exchange.HTTP_RESPONSE_CODE, "403");
	}

}
