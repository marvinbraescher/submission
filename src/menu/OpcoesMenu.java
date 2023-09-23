package menu ;

public enum OpcoesMenu {
	
	CADASTRAR   ( 1 , "  Cadastrar Submissão" 				  ),
	PESQ_SUB    ( 2 , "  Pesquisar Submissão usando a data"   ),
	CAD_AUT     ( 3 , "  Cadastrar Autor (no banco de dados)" ),
	PESQ_AUT    ( 4 , "  Pesquisar autor usando o nome"  	  ),
	LISTAR_SUBS ( 5 , "  Listar todas as Submissões" 		  ),
	LISTAR_AUTS ( 6 , "  Listar todos os Autores" 			  ),
	SAIR        ( 7 , "	 Sair" 								  );
	
	private final int valor ;
	private final String descricao ;
	
	private OpcoesMenu( int valor , String descricao )
	{
		this.valor = valor ;
		this.descricao = descricao ;
	}
	
	public int getValor()
	{
		return valor ;
	}
	
	public String getDescricao()
	{
		return descricao ;
	}
	
	public String getItem()
	{
		return this.getValor() + " - " + this.getDescricao() ;
	}
}
