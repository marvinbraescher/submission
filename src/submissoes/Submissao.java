package submissoes;

import java.util.*;

import util.Situacao;
import util.Validator;
import pessoas.Autor;

 public abstract class Submissao implements Validator {

	private String titulo;
	private Date data;
	private static int total;
	
	public Situacao situacao;
	 
	//add, remove and contains. Main commands <--
	private Set<Autor> autor = new TreeSet<>();
	
	public Submissao( String titulo, Date data ) 
	{
		this.titulo = titulo;
		this.data = data;
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
				+ ", autor=" + autor + "]";
	}

	@Override
	public boolean validarData() 
	{
		// TODO Auto-generated method stub
		return false;
	}

	public Set<Autor> getAutor() {
		return autor;
	}

	public void setAutor(Set<Autor> autor) {
		this.autor = autor;
	}
	
	
}
