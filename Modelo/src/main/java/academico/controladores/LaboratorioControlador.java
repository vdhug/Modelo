package academico.controladores;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import academico.entidades.Curso;
import academico.entidades.Laboratorio;
import academico.repositorios.LaboratorioRepositorio;


@ManagedBean(name="laboratorioMB")
@SessionScoped
public class LaboratorioControlador implements Serializable {

	Laboratorio laboratorio = new Laboratorio();
	LaboratorioRepositorio lr = new LaboratorioRepositorio();

	public Laboratorio getLaboratorio() {
		return laboratorio;
	}

	public void setLaboratorio(Laboratorio laboratorio) {
		this.laboratorio = laboratorio;
	}

	public String novoLaboratorio() {
		laboratorio = new Laboratorio();
		return "laboratorioFormulario";
	}

	public String adicionarLaboratorio() {
		lr.adicionar(laboratorio);
		laboratorio = new Laboratorio();
		listaLaboratorio = null;
		return "laboratorioLista";
	}
	
	
	public String excluirLaboratorio() {
		lr.remover(laboratorio);
		laboratorio = new Laboratorio();
		listaLaboratorio = null;
		return "laboratorioLista";
	}
	
	

	List<Laboratorio> listaLaboratorio = null;
	List<Laboratorio> listaLaboratorioFiltro = null;

	public List<Laboratorio> getListaLaboratorioFiltro() {
		return listaLaboratorioFiltro;
	}

	public void setListaLaboratorioFiltro(List<Laboratorio> listaLaboratorioFiltro) {
		this.listaLaboratorioFiltro = listaLaboratorioFiltro;
	}

	public List<Laboratorio> getListaLaboratorio() {
		if (listaLaboratorio == null)
			listaLaboratorio = lr.listar();
		return listaLaboratorio;
	}

	public String editarLaboratorio(Laboratorio l) {
		laboratorio = l;
		lr.atualizar(laboratorio);
		listaLaboratorio = null;
		return "laboratorioFormulario";
	}

	public String excluirLaboratorio(Laboratorio l) {
		laboratorio = l;
		return "laboratorioConfirmaExclusao";
	}

	public String confirmaExclusaoLaboratorio() {
		lr.remover(laboratorio);
		listaLaboratorio = null;
		return "laboratorioLista";
	}

}
