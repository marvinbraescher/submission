
package pessoas ;

import java.util.Objects ;

import contatos.Telefone ;

public class Autor implements Comparable<Autor> {
	

	private String nome ;
	
	private String email ;
	
	private Telefone telefone ;
	
	
	public Autor( String nome , String email , Telefone telefone )
	{
		super() ;
		this.nome = nome ;
		this.email = email ;
		this.telefone = telefone ;
	}


	public String getNome()
	{
		return nome ;
	}

	
	public void setNome( String nome )
	{
		this.nome = nome ;
	}

	
	public String getEmail()
	{
		return email ;
	}

	
	public void setEmail( String email )
	{
		this.email = email ;
	}

	
	public Telefone getTelefone()
	{
		return telefone ;
	}

	
	public void setTelefone( Telefone telefone )
	{
		this.telefone = telefone ;
	}

	@ Override
	public String toString()
	{
		return "Autor [nome=" + nome + ", email=" + email + ", telefone=" + telefone + "]" ;
	}



    @Override
    public int compareTo(Autor outroAutor) {
        // Comparação com base nos nomes dos autores (ordem lexicográfica)
        return this.nome.compareTo(outroAutor.nome);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Autor outroAutor = (Autor) obj;
        return Objects.equals(nome, outroAutor.nome) &&
               Objects.equals(email, outroAutor.email) &&
               Objects.equals(telefone, outroAutor.telefone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, email, telefone);
    }
	
}
