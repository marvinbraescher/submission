
package menu ;

import java.sql.Connection ;
import java.sql.SQLException ;
import java.util.Date ;

import javax.swing.JOptionPane ;

import database.AutorDAO ;
import database.ConnectionFactory ;
import pessoas.Autor ;
import submissoes.Submissao ;

public class Menu {
	
	public static void main( String[] args ) throws SQLException
	{
		Boolean exit = false;
		AutorDAO autor = new AutorDAO();
		
		while ( !exit )
		{
			switch ( montaMenu() )
			{
				case 1 : 
				{
					Date time = new Date();
					
					JOptionPane.showMessageDialog( null , time ) ;
					
					Connection connection = new ConnectionFactory().getConnection();
					
					if( connection!=null )
					{
						System.out.println("Conexão aberta!");

					}
					else
					{		
						System.out.println("Conexão com exceção!");

					}
					connection.close();
					break;
				}
				case 2 : 
				{
					JOptionPane.showMessageDialog( null , OpcoesMenu.PESQ_SUB.getDescricao() ) ;
					break;
				}
				case 3 : 
				{

					String nome = JOptionPane.showInputDialog( "Nome autor: " );
					String email = JOptionPane.showInputDialog( "Email autor: " );
					
					autor.setAutor( nome , email );
					JOptionPane.showMessageDialog( null , "op3" ) ;
					break;
				}
				case 4 : 
				{
					String nome = JOptionPane.showInputDialog( "Pesquisar por nome do autor: " );
					
					
					JOptionPane.showMessageDialog( null , autor.getAutorByName( nome ) ) ;
					break;
				}
				case 5 : 
				{
					JOptionPane.showMessageDialog( null , "op5" ) ;
					break;
				}
				case 6 : 
				{
					JOptionPane.showMessageDialog( null , autor.getAutores() ) ;
					break;
				}
				case 7 : 
				{
					JOptionPane.showMessageDialog( null , "SAIU" ) ;
					exit = true;
					break;
				}
				default :
					throw new IllegalArgumentException( "Unexpected value: " + montaMenu() ) ;
			}
		}
	
	}
	
	private static int montaMenu()
	{
		String str = "" ;
		for ( OpcoesMenu opcaoMenu : OpcoesMenu.values() )
		{
			str += opcaoMenu.getItem() + "\n" ;
		}
		return Integer.parseInt( JOptionPane.showInputDialog( str ) ) ;
	}
	
}
