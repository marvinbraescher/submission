
package database ;

import java.sql.Connection ;
import java.sql.DriverManager ;
import java.sql.SQLException ;

public class ConnectionFactory {
	
	public Connection getConnection()
	{
		try
		{
			Class.forName( "com.mysql.jdbc.Driver" ) ;
			String urlBD = "jdbc:mysql://localhost:3306/submissao" ;
			return DriverManager.getConnection( urlBD , "root" , "" ) ;
		} catch ( SQLException e )
		{
			System.out.println( "Exceção SQL" ) ;
		} catch ( ClassNotFoundException e )
		{
			System.out.println( "Exceção Classe não encontrada" ) ;
		}
		return null ;
	}
	
}
