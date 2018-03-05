package academico.controladores;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import academico.entidades.Curso;
import academico.repositorios.CursoRepositorio;


@ManagedBean(name="cursoMB")
@SessionScoped
public class CursoControlador implements Serializable{
	Curso curso = new Curso();
	CursoRepositorio cr = new CursoRepositorio();
	public Curso getCurso() {
		return curso;
	}
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	
	public String adicionarCurso() {
		cr.adicionar(curso);
		listaCurso = null;
		return "cursoLista";
	}
	
	List<Curso> listaCurso = null;
//	metodo pra retornar uma lista de Curso
	public List<Curso> getListaCurso() {
		if(listaCurso==null)
			listaCurso = cr.listar();
		return listaCurso;
	}
	
	public String novoCurso() {
		curso = new Curso();
		return "cursoFormulario";
	}
	
	public String editarCurso(Curso c) {
		this.curso = c;
		cr.atualizar(curso);
		listaCurso = null;
		return "cursoFormulario";
	}
	
	public String excluirCurso(Curso c) {
		this.curso = c;
		return "cursoConfirmaExclusao";
	}
	
	public String confirmaExclusaoCurso() {
		cr.remover(curso);
		listaCurso = null;
		return "cursoLista";
	}
	
}






