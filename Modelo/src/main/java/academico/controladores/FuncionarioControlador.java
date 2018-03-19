package academico.controladores;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import academico.entidades.Funcionario;
import academico.repositorios.FuncionarioRepositorio;


@ManagedBean(name="funcionarioMB")
@SessionScoped
//cont
public class FuncionarioControlador implements Serializable{
	
	Funcionario funcionario = new Funcionario();
	FuncionarioRepositorio er = new FuncionarioRepositorio();
	public Funcionario getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	
	public String adicionarFuncionario() {
		er.adicionar(funcionario);
		listaFuncionario = null;
		return "funcionarioLista";
	}
	
	List<Funcionario> listaFuncionario = null;
	List <Funcionario> listaFuncionarioFiltro = null;
	
	public FuncionarioRepositorio getEr() {
		return er;
	}
	public void setEr(FuncionarioRepositorio er) {
		this.er = er;
	}
	public List<Funcionario> getListaFuncionarioFiltro() {
		return listaFuncionarioFiltro;
	}
	public void setListaFuncionarioFiltro(List<Funcionario> listaFuncionarioFiltro) {
		this.listaFuncionarioFiltro = listaFuncionarioFiltro;
	}
	public void setListaFuncionario(List<Funcionario> listaFuncionario) {
		this.listaFuncionario = listaFuncionario;
	}
	public List<Funcionario> getListaFuncionario() {
		if(listaFuncionario==null)
			listaFuncionario = er.listar();
		return listaFuncionario;
	}
	
	public String novaFuncionario() {	
		funcionario = new Funcionario();
		return "funcionarioFormulario";
	}

	public String editarFuncionario (Funcionario e) {
		funcionario = e;
		er.atualizar(funcionario);
		listaFuncionario = null;
		return "funcionarioFormulario";
		
	}
	
	public String excluirFuncionario(Funcionario e) {
		this.funcionario = e;
		return "funcionarioConfirmarExclusao";
		
	}

	public String confirmarExclusaoFuncionario() {
		er.remover(funcionario);
		listaFuncionario = null;
		return "funcionarioListar";
	}
	
}






