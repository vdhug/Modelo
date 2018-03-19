package academico.controladores;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import academico.entidades.Curso;
import academico.entidades.Disciplina;
import academico.repositorios.CursoRepositorio;
import academico.repositorios.DisciplinaRepositorio;




@ManagedBean(name="disciplinaMB")
@SessionScoped
public class DisciplinaControlador implements Serializable{
	Disciplina disciplina = new Disciplina();
	
	Curso curso = new Curso();
	
	private int cursoId;
	
	DisciplinaRepositorio dr = new DisciplinaRepositorio();
	
	public Disciplina getDisciplina() {
		return disciplina;
	}
	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}
	
	
	
	public int getCursoId() {
		return cursoId;
	}
	public void setCursoId(int cursoId) {
		this.cursoId = cursoId;
	}
	public Curso getCurso() {
		return curso;
	}
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	public String novoDisciplina() {
		disciplina = new Disciplina();
		return "disciplinaFormulario";
	}
	
	
	public String adicionarDisciplina() {
		
		curso = dr.recuperarCurso(cursoId);
		
		disciplina.setCurso(curso);
		
		dr.adicionar(disciplina);
		listaDisciplina = null;
		return "disciplinaLista";
	}
	

	public String excluirDisciplina() {
		
				
		dr.remover(disciplina);
		listaDisciplina = null;
		return "disciplinaLista";
	}
	
	List<Disciplina> listaDisciplina = null;
	List<Disciplina> listaDisciplinaFiltro = null;
	
	public List<Disciplina> getListaDisciplinaFiltro() {
		return listaDisciplinaFiltro;
	}
	public void setListaDisciplinaFiltro(List<Disciplina> listaDisciplinaFiltro) {
		this.listaDisciplinaFiltro = listaDisciplinaFiltro;
	}
	
	public List<Disciplina> getListaDisciplina() {
		if(listaDisciplina==null)
			listaDisciplina = dr.listar();
		return listaDisciplina;
	}
	
	public String editarDisciplina(Disciplina dis) {
		disciplina = dis;
		dr.atualizar(disciplina);
		listaDisciplina = null;
		return "disciplinaFormulario";
	}
	
	public String excluirDisciplina(Disciplina dis) {
		disciplina = dis;
		return "disciplinaConfirmaExclusao";
	}
	
	public String confirmaExclusaoDisciplina() {
		dr.remover(disciplina);
		listaDisciplina = null;
		return "disciplinaLista";
	}
	
}
