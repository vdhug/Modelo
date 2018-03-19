package academico.controladores;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import academico.entidades.Discente;
import academico.repositorios.DiscenteRepositorio;




@ManagedBean(name="discenteMB")
@SessionScoped
public class DiscenteControlador implements Serializable{
	Discente discente = new Discente();
	DiscenteRepositorio dr = new DiscenteRepositorio();
	public Discente getDiscente() {
		return discente;
	}
	public void setDiscente(Discente discente) {
		this.discente = discente;
	}
	public String novoDiscente() {
		discente = new Discente();
		return "discenteFormulario";
	}
	public String adicionarDiscente() {
		dr.adicionar(discente);
		listaDiscente = null;
		return "discenteLista";
	}
	
	public String excluirDiscente() {
		dr.remover(discente);
		listaDiscente = null;
		return "discenteLista";
	}
	
	List<Discente> listaDiscente = null;
	List<Discente> listaDiscenteFiltro = null;
	
	public List<Discente> getListaDiscenteFiltro() {
		return listaDiscenteFiltro;
	}
	public void setListaDiscenteFiltro(List<Discente> listaDiscenteFiltro) {
		this.listaDiscenteFiltro = listaDiscenteFiltro;
	}
	
	public List<Discente> getListaDiscente() {
		if(listaDiscente==null)
			listaDiscente = dr.listar();
		return listaDiscente;
	}
	
	public String editarDiscente(Discente c) {
		discente = c;
		dr.atualizar(discente);
		listaDiscente = null;
		return "discenteFormulario";
	}
	
	public String excluirDiscente(Discente c) {
		discente = c;
		return "discenteConfirmaExclusao";
	}
	
	public String confirmaExclusaoDiscente() {
		dr.remover(discente);
		listaDiscente = null;
		return "discenteLista";
	}
	
}
