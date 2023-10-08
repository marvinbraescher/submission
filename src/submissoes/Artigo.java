
package submissoes ;

import java.util.Date ;
import java.util.Set ;

import pessoas.Autor ;

public class Artigo extends Submissao {
	
	private String abstracts ;
	
	private String resumo ;
	
	private String arquivo ;
	
	public Artigo( String titulo , Date data , String abstracts , String resumo , String arquivo, Set<Autor> autores )
	{
		super( titulo, data, autores ) ;
		
		this.abstracts = abstracts ;
		this.resumo = resumo ;
		this.arquivo = arquivo ;
	}
	
	public String getAbstracts()
	{
		return abstracts ;
	}
	
	public void setAbstracts( String abstracts )
	{
		this.abstracts = abstracts ;
	}
	
	public String getResumo()
	{
		return resumo ;
	}
	
	public void setResumo( String resumo )
	{
		this.resumo = resumo ;
	}
	
	public String getArquivo()
	{
		return arquivo ;
	}
	
	@ Override
	public String toString()
	{
		return "Artigo [abstracts=" + abstracts + ", resumo=" + resumo + ", arquivo=" + arquivo + "]" ;
	}
	
	public void setArquivo( String arquivo )
	{
		this.arquivo = arquivo ;
	}
	
}
