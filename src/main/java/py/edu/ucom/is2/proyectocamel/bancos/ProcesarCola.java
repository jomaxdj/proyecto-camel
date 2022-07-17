package py.edu.ucom.is2.proyectocamel.bancos;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;


@Component
public class ProcesarCola implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {
		
		BancoRequest bancoRequest = exchange.getIn().getBody(BancoRequest.class);
				
		if(bancoRequest != null) {
			
			System.out.println("Usamos el process para este: El Banco de origen es: " +bancoRequest.getBanco_origen() + " El Banco de destino es: " +bancoRequest.getBanco_destino() + 
					" Su N° de cuenta es: " +bancoRequest.getCuenta() + " y el monto enviado es: " +bancoRequest.getMonto() + " Le comunicamos que la transferencia fue exitosa!!" );
		}
		else
			System.err.print("El banco de Servicio no puede procesar el pedido.");
	}
}
