package util;

public enum Situacao {

	ENVIADA(1, "ENVIADA"),
	EM_ANALISE(2, "EM_ANALISE"),
	ACEITA(3, "ACEITA"),
	REJEITADA(4, "REJEITADA");
	
	private final String descricao ;
	
	private final int id ;
	
	private Situacao( int id , String descricao )
	{
		this.id = id ;
		this.descricao = descricao ;
	}
	
	public String getDescricao()
	{
		return descricao ;
	}
	
	public int getId()
	{
		return id ;
	}
	
}
