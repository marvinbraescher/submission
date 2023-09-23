
package pessoas ;

import contatos.Telefone ;

public class Autor {
	
	private String nome ;
	
	private String email ;
	
	private Telefone telefone ;
	
	@ Override
	public String toString()
	{
		return "Autor [nome=" + nome + ", email=" + email + ", telefone=" + telefone + "]" ;
	}
	
}
