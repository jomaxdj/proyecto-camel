package py.edu.ucom.is2.proyectocamel.helper;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

@Component
public class MessageGenerator implements Processor{

	@Override
	public void process(Exchange exchange) throws Exception {
	    String body = exchange.getIn().getBody(String.class);
	    exchange.getIn().setBody("Origen JoseMendoza> "+exchange.getIn().getMessageId());
	}
}