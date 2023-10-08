package submissoes;

import java.util.*;

import util.Situacao;
import util.Validator;
import pessoas.Autor;

 public abstract class Submissao implements Validator {

	private String titulo;
	private Date data;
	private static int total = 0;
	
	public Situacao situacao;
	 
	//add, remove and contains. Main commands <--
	private Set<Autor> autores = new TreeSet<>();
	
	public Submissao( String titulo, Date data , Set<Autor> autores ) 
	{
		this.titulo = titulo;
		this.data = data;
		this.situacao = Situacao.ENVIADA;
		this.autores = autores;
	}
	
				
	public String getTitulo() 
	{
		return titulo;
	}
	
	public void setTitulo(String titulo) 
	{
		this.titulo = titulo;
	}
	
	public Date getData() {
		return data;
	}
	
	public void setData(Date data) 
	{
		this.data = data;
	}
	
	public int getTotal() 
	{
		return Submissao.total;
	}
	
	public void setTotal(int total) 
	{
		Submissao.total = total;
	}
	

	@Override
	public String toString() {
		return "Submissao [titulo=" + titulo + ", data=" + data + ", total=" + total + ", situacao=" + situacao
				+ ", autor=" + getAutores() +  "]";
	}

	@Override
	public boolean validarData() 
	{
		// TODO Auto-generated method stub
		return false;
	}

	public String getAutores() {
		String str = "";
		for ( Autor autor : autores )
		{
			str += "Nome: " + autor.getNome() + "\nEmail: " + autor.getEmail() + "\nTelefone: " + autor.getTelefone() +"\n\n";
		}
		
		return str;
	}
	
	public Set<Autor> getAllAutor()
	{
		return this.autores;
	}

	public void setAutor( Autor autor ) {
		autores.add( autor );
	}
	
	
}
