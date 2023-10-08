
package submissoes ;

import java.util.Date ;
import java.util.Set ;

import pessoas.Autor ;


public class Curso extends Submissao {
	

	
	private String justificativa ;
	
	private String material ;
	
	private String objetivo ;
	
	private Double duracao ;
	
	public Curso( String titulo , Date data ,String justificativa, String material, String objetivo, Double duracao, Set<Autor> autores )
	{
		super( titulo, data , autores ) ;
		
		this.duracao = duracao;
		this.objetivo = objetivo;
		this.material = material;
		this.justificativa = justificativa;

	}
	
	public String getJustificativa()
	{ 
		return justificativa ;
	}
	
	public void setJustificativa( String justificativa )
	{
		this.justificativa = justificativa ;
	}
	
	public String getMaterial()
	{
		return material ;
	}
	
	public void setMaterial( String material )
	{
		this.material = material ;
	}
	
	public String getObjetivo()
	{
		return objetivo ;
	}
	
	public void setObjetivo( String objetivo )
	{
		this.objetivo = objetivo ;
	}
	
	public Double getDuracao()
	{
		return duracao ;
	}
	
	public void setDuracao( Double duracao )
	{
		this.duracao = duracao ;
	}
	
	@ Override
	public String toString()
	{
		return "Curso [justificativa=" + justificativa + ", material=" + material + ", objetivo=" + objetivo
				+ ", duracao=" + duracao + "]" ;
	}
	
}
