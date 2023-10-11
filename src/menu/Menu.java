
package menu ;


import java.sql.SQLException ;
import java.text.ParseException ;
import java.text.SimpleDateFormat ;
import java.time.LocalDateTime ;
import java.time.format.DateTimeFormatter ;
import java.util.ArrayList ;
import java.util.Date ;
import java.util.List ;
import java.util.Locale ;
import java.util.Set ;
import java.util.TreeSet ;

import javax.swing.JOptionPane ;

import database.AutorDAO ;

import pessoas.Autor ;
import submissoes.Artigo ;
import submissoes.Curso ;
import submissoes.Submissao ;


public class Menu {
	
	public static void main( String[] args ) throws SQLException
	{
		Boolean exit = false ;
		AutorDAO autor = new AutorDAO() ;
		List<Curso> cursos = new ArrayList<>();
		List<Artigo> artigos = new ArrayList<>();
		
		while ( !exit )
		{
			switch ( montaMenu() )
			{
				case 1 : {
					Date time = new Date() ;
					
					// JOptionPane.showMessageDialog( null , time ) ;
					String[] choices = {"Artigo","Curso"} ;
					String input = ( String ) JOptionPane.showInputDialog( 
							null ,
							"O que deseja submeter?",
							"Escolha", 							
							JOptionPane.QUESTION_MESSAGE,
							null,
							choices,
							choices[0] ) ;
					
					if( isArtigo( input ) ) 
					{
						
							String titulo = JOptionPane.showInputDialog( "Titulo do artigo: " ) ;
							String abstracts = JOptionPane.showInputDialog( "Abstracts do artigo: ","x" ) ;
							String resumo = JOptionPane.showInputDialog( "Resumo do artigo: " ) ;
							String arquivo = JOptionPane.showInputDialog( "Arquivo do artigo: " ) ;
	
								Boolean multipleAutors = true;
								Set<Autor> autores1 = new TreeSet<Autor>();
								while( multipleAutors ) 
								{
									
									Set<Autor> autores = autor.getAutores();
									List<String> nomesAutores = new ArrayList<>();
									
									for (Autor autor2 : autores) 
									{
										nomesAutores.add(autor2.getNome());
									}
									
									String[] choice = nomesAutores.toArray( new String[0] );
									
									String autorChoice = (String) JOptionPane.showInputDialog(
											null,
											"Qual autor deseja submeter?",
											"Qual autor deseja submeter?",
											JOptionPane.OK_OPTION,
											null,
											choice,
											choice[0]
											);
														
									Autor autorByName = autor.getAutorByName( autorChoice ) ;
									autores1.add( autorByName );
									if ( JOptionPane.showConfirmDialog(
											null,
											"Deseja adicionar mais autores?", "WARNING",
									        JOptionPane.YES_NO_OPTION
									        ) == JOptionPane.YES_OPTION) 
									{
										multipleAutors = true;
									} 
									else 
									{
										if ( JOptionPane.showConfirmDialog(
												null,
												"Deseja cadastrar mais autores?", "WARNING",
										        JOptionPane.YES_NO_OPTION
										        ) == JOptionPane.YES_OPTION) 
										{
											String nome = JOptionPane.showInputDialog( "Nome autor: " ) ;
											String email = JOptionPane.showInputDialog( "Email autor: " ) ;
											autor.setAutor( nome , email ) ;
										} 
										else 
										{
											multipleAutors= false;
										}
										
									}
								}
								//Autor autorByName = autor.getAutorByName( autorChoice ) ;
								Artigo artigo = new Artigo(titulo, time, abstracts, resumo, arquivo, autores1  );
								artigo.setTotal( artigo.getTotal() + 1 );
								artigos.add( artigo );
		
					}
					else 
					{
						String titulo = JOptionPane.showInputDialog( "Titulo do curso: " ) ;
						String justificativa = JOptionPane.showInputDialog( "Justificativa do curso: " ) ;
						String material = JOptionPane.showInputDialog( "Material do curso: " ) ;
						String objetivo = JOptionPane.showInputDialog( "Objetivo do curso: " ) ;
						
						Double duracao = Double.valueOf(   JOptionPane.showInputDialog( "Duracao do curso (Double): " ) ) ;
						Boolean multipleAutors = true;
						Set<Autor> autores1 = new TreeSet<Autor>();
						while( multipleAutors ) 
						{
							Set<Autor> autores = autor.getAutores();
							List<String> nomesAutores = new ArrayList<>();
							
							for (Autor autor2 : autores) {
								nomesAutores.add(autor2.getNome());
							}
							
							String[] choice = nomesAutores.toArray( new String[0] );
							
							String autorChoice = (String) JOptionPane.showInputDialog(
									null,
									"Qual autor deseja submeter?",
									"Qual autor deseja submeter?",
									JOptionPane.OK_OPTION,
									null,
									choice,
									choice[0]
									);
												
							Autor autorByName = autor.getAutorByName( autorChoice ) ;
							autores1.add( autorByName );
							if (JOptionPane.showConfirmDialog(null, "Deseja adicionar mais autores?", "WARNING",
							        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
								multipleAutors = true;
							}
							else 
							{
								if ( JOptionPane.showConfirmDialog(
										null,
										"Deseja cadastrar mais autores?", "WARNING",
								        JOptionPane.YES_NO_OPTION
								        ) == JOptionPane.YES_OPTION) 
								{
									String nome = JOptionPane.showInputDialog( "Nome autor: " ) ;
									String email = JOptionPane.showInputDialog( "Email autor: " ) ;
									autor.setAutor( nome , email ) ;
								} 
								else 
								{
									multipleAutors= false;
								}
								
							}
						
						}
						
						Curso curso = new Curso( titulo, time , justificativa, material, objetivo, duracao, autores1 );
						curso.setTotal( curso.getTotal() + 1 );
						cursos.add(curso);

					}
					
					break;
				}
				case 2 : {
					
					String pesqData = JOptionPane.showInputDialog( null , "Buscar por data (dd/mm/aaaa): " ) ;
					String autores = "";
					String[] aux = {""};
					for ( Artigo artigo : artigos ) 
					{
						if(Submissao.formatarData( artigo.getData().toString() ).contains( pesqData ) ) 
						{

							for( Autor autores1 : artigo.getAllAutor() ) 
							{
								autores += "\nNome: " + autores1.getNome() + "\nEmail: " + autores1.getEmail() + "\nTelefone: " + autores1.getTelefone() ;
							}
							aux[0] += "Titulo: " + artigo.getTitulo() + "\nAbstracts: " + artigo.getAbstracts() + "\nResumo: " + artigo.getResumo() + "\nData: " + Submissao.formatarData( artigo.getData().toString() )  + "\nAutor(es): " + autores + "\n\n";
							
						}
					}
					for (Curso curso : cursos )
					{
						if(Submissao.formatarData( curso.getData().toString() ).contains( pesqData ) ) 
						{
							for( Autor autores1 : curso.getAllAutor() ) 
							{
								autores += "\nNome: " + autores1.getNome() + "\nEmail: " + autores1.getEmail() + "\nTelefone: " + autores1.getTelefone();
							}
							aux[0] += "Titulo: " + curso.getTitulo() +"\nMaterial: " + curso.getMaterial() + "\nObjetivo: " + curso.getObjetivo() + "\nJustificativa: " + curso.getJustificativa() + "\nDuracao: " + curso.getDuracao() + "\nData: "  + Submissao.formatarData( curso.getData().toString() )  + "\n Autor(es): " + autores + "\n\n";
						}
						if( aux[0].equals( "" ) ) 
						{
							aux[0] = "Não há Artigo/Curso(s) nessa data!";
						}
					
					
					}
					JOptionPane.showMessageDialog( null , aux[0] ) ;
					break ;
				}
				case 3 : {
					String nome = JOptionPane.showInputDialog( "Nome autor: " ) ;
					String email = JOptionPane.showInputDialog( "Email autor: " ) ;
					autor.setAutor( nome , email ) ;
					break ;
				}
				case 4 : {
					Set<Autor> autores = autor.getAutores();
					List<String> nomesAutores = new ArrayList<>();
					
					for (Autor autor2 : autores) {
						nomesAutores.add(autor2.getNome());
					}
					
					String[] choice = nomesAutores.toArray( new String[0] );
					
					String autorChoice = (String) JOptionPane.showInputDialog(
							null,
							"Qual autor deseja procurar",
							"Qual autor deseja procurar?",
							JOptionPane.OK_OPTION,
							null,
							choice,
							choice[0]
							);
										
					Autor autorByName = autor.getAutorByName( autorChoice ) ;
					JOptionPane.showMessageDialog( null , autorByName.toString() ) ;

					
					break ;
				}
				case 5 : {
					String aux = "";
					String autores = "";
					for ( Artigo artigo : artigos )
					{
						for( Autor autores1 : artigo.getAllAutor() ) 
						{
							autores += "\nNome: " + autores1.getNome() + "\nEmail: " + autores1.getEmail() + "\nTelefone: " + autores1.getTelefone() ;
						}
						aux += "Titulo: " + artigo.getTitulo() + "\nAbstracts: " + artigo.getAbstracts() + "\nResumo: " + artigo.getResumo() + "\nData: " + Submissao.formatarData( artigo.getData().toString() )  + "\nAutor(es): " + autores + "\n\n";
						
					}
					for ( Curso curso : cursos )
					{
						for( Autor autores1 : curso.getAllAutor() ) 
						{
							autores += "\nNome: " + autores1.getNome() + "\nEmail: " + autores1.getEmail() + "\nTelefone: " + autores1.getTelefone();
						}
						aux += "Titulo: " + curso.getTitulo() +"\nMaterial: " + curso.getMaterial() + "\nObjetivo: " + curso.getObjetivo() + "\nJustificativa: " + curso.getJustificativa() + "\nDuracao: " + curso.getDuracao() + "Data: "  + Submissao.formatarData( curso.getData().toString() )  + "\n Autor(es): " + autores + "\n\n";
					}
					if( aux.equals( "" ) ) 
					{
						aux = "Não há Artigo/Curso(s) cadastrado(s)";
					}
					JOptionPane.showMessageDialog( null , aux ) ;
					break ;
				}
				case 6 : {
					Set<Autor> autores = autor.getAutores();
					String aux = "";
					
					for ( Autor autor2 : autores )
					{
						aux += "Nome: " + autor2.getNome() + "\nEmail: " + autor2.getEmail() + "\nTelefone: " + autor2.getTelefone() + "\n\n";
					}
					JOptionPane.showMessageDialog( null , aux ) ;
					break ;
				}
				case 7 : {
					JOptionPane.showMessageDialog( null , "Obrigado, volte sempre!" ) ;
					exit = true ;
					break ;
				}
				default :
					JOptionPane.showMessageDialog( null , "Opcao invalida!" ) ;
			//		throw new IllegalArgumentException( "Unexpected value: " + montaMenu() ) ;
			}
		}
	}
	
	private static int montaMenu()
	{
		String str = "" ;
		int x = 0;
		for ( OpcoesMenu opcaoMenu : OpcoesMenu.values() )
		{
			str += opcaoMenu.getItem() + "\n" ;
		}

		try 
		{
			x = Integer.parseInt( JOptionPane.showInputDialog( str ) );
		}
		catch(NumberFormatException e) 
		{
			x = 8;
		}
		return x;
	}
	
	/**
	 * Recebe uma String do JOptionPane e devolve um boleano
	 * @param String choice
	 * @return true or false
	 */
	public static Boolean isArtigo( String choice ) 
	{
		Boolean isArtigo = false;
		if( choice.equals( "Artigo" ) ) 
		{
			isArtigo = true;
		}
		return isArtigo;
	}
	

    


	
}
