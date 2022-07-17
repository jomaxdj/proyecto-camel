package py.edu.ucom.is2.proyectocamel.routes;

import java.time.LocalDateTime;

import org.apache.camel.builder.RouteBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;

@Component

public class Practica2 extends RouteBuilder{
	@Autowired
	Reloj relojInyectado;
	
	@Override
	public void configure() throws Exception {
		from("timer:mytimer?period=1000")
		.transform().constant("Mensaje Original")
		.process(new Procesador())
		.transform().constant("Mensaje Original2")
		.to("log:mylogger");
	}
	
}

@Component

class Procesador implements Processor {
	Logger logger = LoggerFactory.getLogger(Practica2.class);

	@Override
	public void process(Exchange exchange) throws Exception {
		String body = exchange.getIn().getBody(String.class);
		//logger.info("El header del Exchange original es: "+exchange.getOut().getHeaders());
		//logger.info("El header del Exchange modificado es: "+exchange.getOut().getHeaders());
		//logger.info("SimpleProcessor {}", exchange.getMessage().getBody()); este era el original
		exchange.getOut().setBody("mensaje modificado");
	} 
	
	
}