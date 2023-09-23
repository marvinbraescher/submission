
package submissoes ;

import java.util.Date ;

import util.Situacao ;

public class Curso extends Submissao {
	
	public Curso( String titulo , Date data , int total , Situacao situacao )
	{
		super( titulo, data ) ;
		// TODO Auto-generated constructor stub
	}
	
	private String justificativa ;
	
	private String material ;
	
	private String objetivo ;
	
	private Double duracao ;
	
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
