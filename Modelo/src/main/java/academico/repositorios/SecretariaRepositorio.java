package academico.repositorios;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import academico.entidades.Secretaria;


public class SecretariaRepositorio {

	private EntityManagerFactory emf;
	private EntityManager em;
	
	public SecretariaRepositorio (){
		emf = Persistence.createEntityManagerFactory("AgendaLabJPA");
		em = emf.createEntityManager();
	}

	public void adicionar(Secretaria secretaria){
		em.getTransaction().begin();
		em.persist(secretaria);
		em.getTransaction().commit();
	}
	public Secretaria recuperar(int id){
		return em.find(Secretaria.class, id);
	}
	public void atualizar(Secretaria secretaria){
		em.getTransaction().begin();
		em.merge(secretaria);
		em.getTransaction().commit();
	}
	public void remover(Secretaria secretaria){
		em.getTransaction().begin();
		em.remove(secretaria);
		em.getTransaction().commit();
	}	
	public void encerrar(){
		em.close();
		emf.close();
	}
	
	public List<Secretaria> listar() {
		Query qr = em.createQuery("from Secretaria c");
		return qr.getResultList();
	}
	
}
