package academico.repositorios;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import academico.entidades.Funcionario;


public class FuncionarioRepositorio {

	private EntityManagerFactory emf;
	private EntityManager em;
	
	public FuncionarioRepositorio() {
		emf = Persistence.createEntityManagerFactory("AcademicoJPA");
		em = emf.createEntityManager();
	}

	public void adicionar(Funcionario funcionario){
		em.getTransaction().begin();
		em.persist(funcionario);
		em.getTransaction().commit();
	}
	public Funcionario recuperar(int id){
		return em.find(Funcionario.class, id);
	}
	public void atualizar(Funcionario funcionario){
		em.getTransaction().begin();
		em.merge(funcionario);
		em.getTransaction().commit();
	}
	public void remover(Funcionario funcionario){
		em.getTransaction().begin();
		em.remove(funcionario);
		em.getTransaction().commit();
	}
	public List<Funcionario> listar() {
		Query qr = em.createQuery("from Funcionario e");
		return qr.getResultList();
	}

	public void encerrar(){
		em.close();
		emf.close();
	}
}
