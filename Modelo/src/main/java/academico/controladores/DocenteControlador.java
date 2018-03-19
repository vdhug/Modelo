package academico.controladores;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import academico.entidades.Docente;
import academico.repositorios.DocenteRepositorio;




@ManagedBean(name="docenteMB")
@SessionScoped
public class DocenteControlador implements Serializable{
	Docente docente = new Docente();
	DocenteRepositorio dr = new DocenteRepositorio();
	public Docente getDocente() {
		return docente;
	}
	public void setDocente(Docente docente) {
		this.docente = docente;
	}
	public String novoDocente() {
		docente = new Docente();
		return "docenteFormulario";
	}
	public String adicionarDocente() {
		dr.adicionar(docente);
		listaDocente = null;
		return "docenteLista";
	}
	
	public String excluirDocente() {
		dr.remover(docente);
		listaDocente = null;
		return "docenteLista";
	}
	
	List<Docente> listaDocente = null;
	List<Docente> listaDocenteFiltro = null;
	
	public List<Docente> getListaDocenteFiltro() {
		return listaDocenteFiltro;
	}
	public void setListaDocenteFiltro(List<Docente> listaDocenteFiltro) {
		this.listaDocenteFiltro = listaDocenteFiltro;
	}
	
	public List<Docente> getListaDocente() {
		if(listaDocente==null)
			listaDocente = dr.listar();
		return listaDocente;
	}
	
	public String editarDocente(Docente doc) {
		docente = doc;
		dr.atualizar(docente);
		listaDocente = null;
		return "docenteFormulario";
	}
	
	public String excluirDocente(Docente doc) {
		docente = doc;
		return "docenteConfirmaExclusao";
	}
	
	public String confirmaExclusaoDocente() {
		dr.remover(docente);
		listaDocente = null;
		return "docenteLista";
	}
	
}
