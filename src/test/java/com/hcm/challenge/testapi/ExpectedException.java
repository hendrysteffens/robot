package com.hcm.challenge.testapi;

import java.util.Arrays;

/**
 * 
 * Essa classe foi criada para testar se as exceções saem como o esperado,<br> 
 * como as exceções criadas extende a WebApplicationException precisa estar dentro de um Web Container.<br> 
 * <b>Observação:</b><br>
 * Não consegui simular um fake(Sem usar api alguma) para os junit tests. 
 * 
 * @author root
 *
 */

public class ExpectedException {

	public static ExpectedException none(){
		return new ExpectedException();
	}
	
	public boolean expect(Class<? extends Throwable> expectError, Throwable error){
		return Arrays.asList(error.getStackTrace())
			.stream().anyMatch(e -> e.getClassName().equals(expectError.getName()));
	}
	
}
