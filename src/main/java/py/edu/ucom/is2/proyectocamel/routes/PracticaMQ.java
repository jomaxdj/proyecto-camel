package py.edu.ucom.is2.proyectocamel.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class PracticaMQ extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		from("timer:timermq").transform().constant("nuevo mensaje").to("activemq:is2mq");
	}

}
