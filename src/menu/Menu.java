
package menu ;

import java.util.Date ;

import javax.swing.JOptionPane ;

import submissoes.Submissao ;


public class Menu {
	
	public static void main( String[] args )
	{
		Boolean exit = false;
		
		while ( !exit )
		{
			switch ( montaMenu() )
			{
				case 1 : 
				{
					
					String title = "";
					Date time = new Date();
					
					JOptionPane.showMessageDialog( null , time ) ;
					break;
				}
				case 2 : 
				{
					JOptionPane.showMessageDialog( null , OpcoesMenu.PESQ_SUB.getDescricao() ) ;
					break;
				}
				case 3 : 
				{
					JOptionPane.showMessageDialog( null , "op3" ) ;
					break;
				}
				case 4 : 
				{
					JOptionPane.showMessageDialog( null , "op4" ) ;
					break;
				}
				case 5 : 
				{
					JOptionPane.showMessageDialog( null , "op5" ) ;
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
