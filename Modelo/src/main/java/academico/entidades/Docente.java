package academico.entidades;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@DiscriminatorValue("Docente")
public class Docente extends Usuario {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String matricula;
	private String nome;
	
	
	public int getId() {
		return id;
	}
	
	
	
	
	public String getMatricula() {
		return matricula;
	}




	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}




	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
