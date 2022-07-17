package py.edu.ucom.is2.proyectocamel.bancos;

import org.springframework.stereotype.Component;

@Component
public class BancoService {
	public BancoResponse transferenciaBanco(BancoRequest bancoRequest) {
		
		BancoResponse respuesta = new BancoResponse();
		
		
		System.out.println("Usamos el bean para este proceso: El Banco de origen es " +bancoRequest.getBanco_origen() + " y el Banco de destino es " +bancoRequest.getBanco_destino() + 
				" el numero de cuenta es " +bancoRequest.getCuenta() + " y el monto enviado fue de " +bancoRequest.getMonto() + ". Le comunicamos que la transferencia fue exitosa!!" );
		
		return respuesta;
		
	}

}
