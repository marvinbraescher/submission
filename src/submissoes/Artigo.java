
package submissoes ;

import java.util.Date ;

public class Artigo extends Submissao {
	
	public Artigo( String titulo , Date data   )
	{
		super( titulo, data ) ;
		// TODO Auto-generated constructor stub

	}
	
	private String abstracts ;
	
	private String resumo ;
	
	private String arquivo ;
	
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
