package database;

import java.sql.Connection ;
import java.sql.DriverManager ;
import java.sql.PreparedStatement ;
import java.sql.ResultSet ;
import java.sql.SQLException ;
import java.sql.Statement ;



public class AutorDAO 
{

	public void setAutor( String nome, String email ) throws SQLException 
	{
		Connection connection = new ConnectionFactory().getConnection();
		if( connection!=null ) 
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
	
	public String getAutores() throws SQLException 
	{
		Connection connection = new ConnectionFactory().getConnection();
		ResultSet rs = null;
		String autores = "";
		if( connection != null ) 
		{			
			System.out.println("Conexão aberta!");
			String sql = "SELECT * from autor";
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);			
			while( rs.next() ) 
			{  
				autores += "Nome: " + rs.getString( "nome" ) + "\n Email: " + rs.getString( "email" ) + "\n--------------------------\n"  ;
			}
		}
		else 
		{
			System.out.println("Conexão com exceção!");
		}
		
		connection.close();
	
	
		return autores;
	}
	
	
	public String getAutorByName( String name ) throws SQLException 
	{
		Connection connection = new ConnectionFactory().getConnection();
		PreparedStatement query;
		String autor = "";
		if( connection != null ) 
		{			
			System.out.println("Conexão aberta!");
			query = connection.prepareStatement( "SELECT * FROM autor WHERE autor.nome = ?" );
			query.setString( 1 , name );

			ResultSet rs = 	query.executeQuery();
			while( rs.next() ) 
			{
				autor += "Nome: " + rs.getString( "nome" ) + "\nEmail: " +rs.getString( "email" );
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
