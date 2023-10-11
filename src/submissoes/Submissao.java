package submissoes;

import java.text.ParseException ;
import java.text.SimpleDateFormat ;
import java.time.LocalDateTime ;
import java.time.format.DateTimeFormatter ;
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
	
	   public static String formatarData(String dataString) {
	        // Formato de entrada
	        DateTimeFormatter formatoEntrada = DateTimeFormatter.ofPattern("EEE MMM dd HH:mm:ss zzz yyyy", Locale.ENGLISH);

	        // Formato de saída
	        DateTimeFormatter formatoSaida = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	        try {
	            // Convertendo a string de entrada para LocalDateTime
	            LocalDateTime data = LocalDateTime.parse(dataString, formatoEntrada);

	            // Formatando a data conforme o formato de saída
	            return data.format(formatoSaida);
	        } catch (Exception e) {
	            e.printStackTrace();
	            return null; // Ou você pode lançar uma exceção aqui, dependendo do seu caso de uso.
	        }
	
	   }
	   public static String convertData(String dataString) {
	        // Formato de entrada
	        SimpleDateFormat formatoEntrada = new SimpleDateFormat("dd/MM/yyyy");

	        // Formato de saída
	        SimpleDateFormat formatoSaida = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.ENGLISH);

	        try {
	            // Convertendo a string de entrada para um objeto Date
	            Date data = formatoEntrada.parse(dataString);

	            // Formatando a data conforme o formato de saída
	            return formatoSaida.format(data);
	        } catch (ParseException e) {
	            e.printStackTrace();
	            return null; // Ou você pode lançar uma exceção aqui, dependendo do seu caso de uso.
	        }
	    }
}
