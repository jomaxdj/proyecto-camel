package py.edu.ucom.is2.proyectocamel.routes;

import java.time.LocalDateTime;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class RouteTest extends RouteBuilder{

	@Autowired
	Reloj relojInyectado;
	
	@Override
	public void configure() throws Exception {
		//ruta que copie de una carpeta origen
		//a una carpeta destino
		/*from ("file:archivos/input")//carpeta origen
		.log("${body}")
		.to("file:archivos/output");*/
		
		//timer  (componente endpoint)
		//transformaciones
		//logger
		from("timer:mytimer?period=5000")
		//.transform().constant("Hora actual es " +LocalDateTime.now())
		.bean(relojInyectado)
		.log("${body}")
		.to("log:mylogger");
		
	}

}

@Component
class Reloj {
	public String reloj() {
		return ("Hora actual es "+LocalDateTime.now());
	}
}