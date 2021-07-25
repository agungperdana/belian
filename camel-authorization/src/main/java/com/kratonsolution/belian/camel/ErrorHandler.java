package com.kratonsolution.belian.camel;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 2.0.0
 */
public class ErrorHandler implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {

		exchange.getMessage().setBody(ResponseBuilder.error(exchange.getException()));
	}

}
