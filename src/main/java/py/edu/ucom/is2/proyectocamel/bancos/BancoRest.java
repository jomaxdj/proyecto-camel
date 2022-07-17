package py.edu.ucom.is2.proyectocamel.bancos;

import org.apache.camel.ExchangePattern;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.stereotype.Component;

//@Component
public class BancoRest extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		// TODO Auto-generated method stub
		restConfiguration().component("servlet").bindingMode(RestBindingMode.auto);
		
		rest().path("/api")
			.get("/saludar")
			.produces("text/plain")
			.to("direct:enviar")
			
		
		.post("/enviar-saludo")
		.to("direct:procesar-saludo");
		//.to("direct:encolar");
		
		from("direct:enviar").transform().constant("Hola Mundo");
		from("direct:procesar-saludo").transform().simple("Recibido ${body}");
		
		//Route va a procesar el post enviar
		from("direct:encolar")
		.setExchangePattern(ExchangePattern.InOnly)
		.to("activemq:rest-JoseMendoza")
		.setExchangePattern(ExchangePattern.InOut)
		.transform().simple("Mensaje Encolado - JM")
		;
		
		
		
	}

}
