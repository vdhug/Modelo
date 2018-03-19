package academico.entidades;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Curso {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
		
	public int codigo;
	private String nome;
	// LÁ DEVERIA SER ManyToOne
    @OneToMany(mappedBy = "curso", cascade = {CascadeType.ALL})
	private List<Disciplina> disciplinas = new ArrayList<Disciplina>();
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public List<Disciplina> getDisicplinas() {
		return disciplinas;
	}
	public void setDisicplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}
	
}
