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
	public String novoCurso() {
		curso = new Curso();
		return "cursoFormulario";
	}
	public String adicionarCurso() {
		cr.adicionar(curso);
		curso = new Curso();
		listaCurso = null;
		return "cursoLista";
	}
	
	public String excluirCurso() {
		cr.remover(curso);
		curso = new Curso();
		listaCurso = null;
		return "cursoLista";
	}
	
	List<Curso> listaCurso = null;
	List<Curso> listaCursoFiltro = null;
	
	public List<Curso> getListaCursoFiltro() {
		return listaCursoFiltro;
	}
	public void setListaCursoFiltro(List<Curso> listaCursoFiltro) {
		this.listaCursoFiltro = listaCursoFiltro;
	}
	
	public List<Curso> getListaCurso() {
		if(listaCurso==null)
			listaCurso = cr.listar();
		return listaCurso;
	}
	
	public String editarCurso(Curso c) {
		curso = c;
		cr.atualizar(curso);
		listaCurso = null;
		return "cursoFormulario";
	}
	
	public String excluirCurso(Curso c) {
		curso = c;
		return "cursoConfirmaExclusao";
	}
	
	public String confirmaExclusaoCurso() {
		cr.remover(curso);
		listaCurso = null;
		return "cursoLista";
	}
	
}
