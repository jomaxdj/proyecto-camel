package py.edu.ucom.is2.proyectocamel.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

//@Component
public class PracticaMQ extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		// TODO Auto-generated method stub
		from("timer:timermq").transform().constant("Nuevo Mensaje").to("activemq:is2mq");
		//from("activemq:is2mq").log("${body}").log("log:is2log");
		
	}
	

}
