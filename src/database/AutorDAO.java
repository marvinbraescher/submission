package database;

import java.sql.Connection ;
import java.sql.PreparedStatement ;
import java.sql.ResultSet ;
import java.sql.SQLException ;
import java.sql.Statement ;
import java.util.Set ;
import java.util.TreeSet ;

import contatos.Telefone ;
import pessoas.Autor ;



public class AutorDAO 
{

	public void setAutor( String nome, String email ) throws SQLException 
	{
		Connection connection = new ConnectionFactory().getConnection();
		if( connection != null ) 
		{			
			PreparedStatement query;
			System.out.println("Conexão aberta!");
			query = connection.prepareStatement( "INSERT INTO autor(nome, email) VALUES( ?, ? )" );
			
			query.setString( 1 , nome );
			query.setString( 2 , email );
			
			query.executeUpdate();
		}
		else 
		{
			System.out.println("Conexão com exceção!");
		}
		
		connection.close();
	}
	
	public Set<Autor> getAutores() throws SQLException 
	{
		Connection connection = new ConnectionFactory().getConnection();
		ResultSet rs = null;
		Set< Autor > autores = new TreeSet < Autor >();
		if( connection != null ) 
		{			
			System.out.println("Conexão aberta!");
			String sql = "SELECT * from autor";
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);			

			while( rs.next() ) 
			{  	
				Autor autor = new Autor( rs.getString( "nome" ), rs.getString( "email" ) , new Telefone(51, 512423123) );
				autores.add( autor );
			}
		}
		else 
		{
			System.out.println("Conexão com exceção!");
		}
		
		connection.close();
	
		return autores;
	}
	
	
	public Autor getAutorByName( String name ) throws SQLException 
	{
		Connection connection = new ConnectionFactory().getConnection();
		PreparedStatement query;
		Autor autor = null; 
		if( connection != null ) 
		{			
			System.out.println("Conexão aberta!");
			query = connection.prepareStatement( "SELECT * FROM autor WHERE autor.nome = ?" );
			query.setString( 1 , name );

			ResultSet rs = 	query.executeQuery();
			while( rs.next() ) 
			{
				 autor = new Autor( rs.getString( "nome" ), rs.getString( "email" ) , new Telefone(51, 512423123) );
			}
		}
		else 
		{
			System.out.println("Conexão com exceção!");
		}
		
		connection.close();

		return autor;
	}
			
}
