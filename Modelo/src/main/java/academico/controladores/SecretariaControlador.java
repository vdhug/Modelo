package academico.controladores;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import academico.entidades.Secretaria;
import academico.repositorios.SecretariaRepositorio;



@ManagedBean(name="secretariaMB")
@SessionScoped
public class SecretariaControlador implements Serializable{
	Secretaria secretaria = new Secretaria();
	SecretariaRepositorio sr = new SecretariaRepositorio();
	public Secretaria getSecretaria() {
		return secretaria;
	}
	public void setSecretaria(Secretaria secretaria) {
		this.secretaria = secretaria;
	}
	public String novoSecretaria() {
		secretaria = new Secretaria();
		return "secretariaFormulario";
	}
	public String adicionarSecretaria() {
		sr.adicionar(secretaria);
		listaSecretaria = null;
		return "secretariaLista";
	}
	
	public String excluirSecretaria() {
		sr.remover(secretaria);
		listaSecretaria = null;
		return "secretariaLista";
	}
	
	List<Secretaria> listaSecretaria = null;
	List<Secretaria> listaSecretariaFiltro = null;
	
	public List<Secretaria> getListaSecretariaFiltro() {
		return listaSecretariaFiltro;
	}
	public void setListaSecretariaFiltro(List<Secretaria> listaSecretariaFiltro) {
		this.listaSecretariaFiltro = listaSecretariaFiltro;
	}
	
	public List<Secretaria> getListaSecretaria() {
		if(listaSecretaria==null)
			listaSecretaria = sr.listar();
		return listaSecretaria;
	}
	
	public String editarSecretaria(Secretaria sec) {
		secretaria = sec;
		sr.atualizar(secretaria);
		listaSecretaria = null;
		return "secretariaFormulario";
	}
	
	public String excluirSecretaria(Secretaria s) {
		secretaria = s;
		return "secretariaConfirmaExclusao";
	}
	
	public String confirmaExclusaoSecretaria() {
		sr.remover(secretaria);
		listaSecretaria = null;
		return "secretariaLista";
	}
	
}
