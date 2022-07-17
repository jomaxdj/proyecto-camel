package py.edu.ucom.is2.proyectocamel.bancos;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.apache.camel.component.jackson.JacksonDataFormat;
import org.apache.camel.model.ProcessorDefinition;
import org.apache.camel.model.RouteDefinition;
import org.apache.camel.model.dataformat.JsonDataFormat;
import py.edu.ucom.is2.proyectocamel.bancos.BancoRequest;
import py.edu.ucom.is2.proyectocamel.bancos.BancoService;
import py.edu.ucom.is2.proyectocamel.bancos.ProcesarCola;
import py.edu.ucom.is2.proyectocamel.routes.rest.tipos.AlumnoResponse;


@Component
public class BancoConsumidorBNG extends RouteBuilder{
	
	private JacksonDataFormat jsonDataFormat;
	
	@Autowired
	BancoService bancoService;
	
	@Override
	public void configure() throws Exception {
		// TODO Auto-generated method stub
			
		jsonDataFormat = new JacksonDataFormat(BancoRequest.class);
		
		from("activemq:JoseMendoza-BNG-IN")
		//.log("${body}")
		.unmarshal(jsonDataFormat)
		//.process(new ProcessorCola())
		.bean(bancoService)
		.end();
		
	}


}

