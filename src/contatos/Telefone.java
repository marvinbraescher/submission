
package contatos ;

public class Telefone {
	
	private int ddd ;
	
	private long numero ;
	
	public Telefone( int ddd , long numero )
	{
		super() ;
		this.ddd = ddd ;
		this.numero = numero ;
	}

	public String toString()
	{
		return "(" + ddd + ")" + numero ;
	}
	
}
