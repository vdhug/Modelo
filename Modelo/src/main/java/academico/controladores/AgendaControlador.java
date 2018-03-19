package academico.controladores;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import academico.entidades.Agenda;
import academico.entidades.Docente;
import academico.entidades.Laboratorio;
import academico.repositorios.AgendaRepositorio;

@ManagedBean(name = "agendaMB")
@SessionScoped
public class AgendaControlador implements Serializable {
	Agenda agenda = new Agenda();

	private int docenteId;

	private int laboratorioId;

	AgendaRepositorio ar = new AgendaRepositorio();

	public Agenda getAgenda() {
		return agenda;
	}

	public void setAgenda(Agenda agenda) {
		this.agenda = agenda;
	}

	public String novoAgenda() {
		agenda = new Agenda();
		return "agendaFormulario";
	}

	public int getDocenteId() {
		return docenteId;
	}

	public void setDocenteId(int docenteId) {
		this.docenteId = docenteId;
	}

	public int getLaboratorioId() {
		return laboratorioId;
	}

	public void setLaboratorioId(int laboratorioId) {
		this.laboratorioId = laboratorioId;
	}

	public String adicionarAgenda() {

		Docente d = ar.recuperarDocente(docenteId);
		Laboratorio l = ar.recuperarLaboratorio(laboratorioId);

		agenda.setDocente(d);
		agenda.setLaboratorio(l);

		ar.adicionar(agenda);
		listaAgenda = null;
		return "agendaLista";
	}

	public String excluirAgenda() {

		ar.remover(agenda);
		listaAgenda = null;
		return "agendaLista";
	}

	List<Agenda> listaAgenda = null;
	List<Agenda> listaAgendaFiltro = null;

	public List<Agenda> getListaAgendaFiltro() {
		return listaAgendaFiltro;
	}

	public void setListaAgendaFiltro(List<Agenda> listaAgendaFiltro) {
		this.listaAgendaFiltro = listaAgendaFiltro;
	}

	public List<Agenda> getListaAgenda() {
		if (listaAgenda == null)
			listaAgenda = ar.listar();
		return listaAgenda;
	}

	public String editarAgenda(Agenda ag) {
		agenda = ag;
		ar.atualizar(agenda);
		listaAgenda = null;
		return "agendaFormulario";
	}

	public String excluirAgenda(Agenda ag) {
		agenda = ag;
		return "agendaConfirmaExclusao";
	}

	public String confirmaExclusaoAgenda() {
		ar.remover(agenda);
		listaAgenda = null;
		return "agendaLista";
	}

}
