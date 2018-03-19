package academico.controladores;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import academico.entidades.Funcionario;
import academico.repositorios.EscolaRepositorio;
import academico.repositorios.FuncionarioRepositorio;



@ManagedBean(name="funcionarioMB")
@SessionScoped
public class FuncionarioControlador implements Serializable{
	FuncionarioRepositorio fr = new FuncionarioRepositorio();
	EscolaRepositorio er = new EscolaRepositorio();
	Funcionario funcionario = new Funcionario();
	private int id;
	
	List<Funcionario> listFuncionarios = null;
	
	public Funcionario getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String adicionarFuncionario() {
        funcionario.setEscola(er.recuperar(id));
        fr.adicionar(funcionario);
        return "funcionarioLista";
    }
    
    public List<Funcionario> listarFuncionarios() {
        if(listFuncionarios ==null)
         listFuncionarios = fr.listar();
        return listFuncionarios;
    }
    
}
