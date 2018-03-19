package academico.controladores;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import academico.entidades.Escola;
import academico.repositorios.EscolaRepositorio;


@ManagedBean(name="escolaMB")
@SessionScoped
public class EscolaControlador implements Serializable{
	Escola escola = new Escola();
	EscolaRepositorio er = new EscolaRepositorio();
	public Escola getEscola() {
		return escola;
	}
	public void setEscola(Escola escola) {
		this.escola = escola;
	}
	
	public String adicionarEscola() {
		er.adicionar(escola);
		listaEscola = null;
		return "escolaLista";
	}
	
	List<Escola> listaEscola = null;
	List <Escola> listaEscolaFiltro = null;
	
	public EscolaRepositorio getEr() {
		return er;
	}
	public void setEr(EscolaRepositorio er) {
		this.er = er;
	}
	public List<Escola> getListaEscolaFiltro() {
		return listaEscolaFiltro;
	}
	public void setListaEscolaFiltro(List<Escola> listaEscolaFiltro) {
		this.listaEscolaFiltro = listaEscolaFiltro;
	}
	public void setListaEscola(List<Escola> listaEscola) {
		this.listaEscola = listaEscola;
	}
	public List<Escola> getListaEscola() {
		if(listaEscola==null)
			listaEscola = er.listar();
		return listaEscola;
	}
	
	public String novaEscola() {	
		escola = new Escola();
		return "escolaFormulario";
	}

	public String editarEscola (Escola e) {
		escola = e;
		er.atualizar(escola);
		listaEscola = null;
		return "escolaFormulario";
		
	}
	
	public String excluirEscola(Escola e) {
		this.escola = e;
		return "escolaConfirmarExclusao";
		
	}

	public String confirmarExclusaoEscola() {
		er.remover(escola);
		listaEscola = null;
		return "escolaListar";
	}
	
}






