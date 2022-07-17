package py.edu.ucom.is2.proyectocamel.bancos;

import py.edu.ucom.is2.proyectocamel.bancos.ProcesarCola;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jackson.JacksonDataFormat;
import org.apache.camel.model.ProcessorDefinition;
import org.apache.camel.model.RouteDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BancoConsumidorBBVA extends RouteBuilder{

	private JacksonDataFormat jsonDataFormat;
	
	@Autowired
	//BancoRequest bancoRequest;
	BancoService bancoService;
	
	@Override
	public void configure() throws Exception {
		// TODO Auto-generated method stub
		
		jsonDataFormat = new JacksonDataFormat(BancoRequest.class);

	
		from("activemq:JoseMendoza-BBVA-IN")
		//log("${body}")
		.unmarshal(jsonDataFormat)
		//.process(new ProcessorCola())
		.bean(bancoService)
		.end();
		
		
	}

	

	
	

}
