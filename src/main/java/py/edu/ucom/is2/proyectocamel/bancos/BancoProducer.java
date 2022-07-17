package py.edu.ucom.is2.proyectocamel.bancos;


import org.apache.camel.ExchangePattern;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class BancoProducer extends RouteBuilder{

	@Autowired
	BancoService service;
	
	@Override
	public void configure() throws Exception {
		// TODO Auto-generated method stub
		restConfiguration().component("servlet").bindingMode(RestBindingMode.off);
		
		rest().path("/api")
			.consumes("application/json")
			.produces("application/json")
			
		.post("/transferencia")
			.to("direct:procesarSwitch");
		
		//Encolamos los Mensajes recibidos
		from("direct:procesarSwitch")
			.choice()
			.when(header("banco_destino").contains("BNG"))
				.setExchangePattern(ExchangePattern.InOnly)
				.to("activemq:JoseMendoza-BNG-IN")
				.setExchangePattern(ExchangePattern.InOut).transform().simple("Mensaje Encolado - BNG")
				.endChoice()
			.when(header("banco_destino").contains("BBVA"))
				.setExchangePattern(ExchangePattern.InOnly)
				.to("activemq:JoseMendoza-BBVA-IN")
				.setExchangePattern(ExchangePattern.InOut).transform().simple("Mensaje Encolado - BBVA")
				.endChoice()
			.otherwise()
				.transform().constant("El valor enviado no es valido");
		
	}

}
