package academico.repositorios;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import academico.entidades.Discente;


public class DiscenteRepositorio {

	private EntityManagerFactory emf;
	private EntityManager em;
	
	public DiscenteRepositorio (){
		emf = Persistence.createEntityManagerFactory("AgendaLabJPA");
		em = emf.createEntityManager();
	}

	public void adicionar(Discente discente){
		em.getTransaction().begin();
		em.persist(discente);
		em.getTransaction().commit();
	}
	public Discente recuperar(int id){
		return em.find(Discente.class, id);
	}
	public void atualizar(Discente discente){
		em.getTransaction().begin();
		em.merge(discente);
		em.getTransaction().commit();
	}
	public void remover(Discente discente){
		em.getTransaction().begin();
		em.remove(discente);
		em.getTransaction().commit();
	}	
	public void encerrar(){
		em.close();
		emf.close();
	}
	
	public List<Discente> listar() {
		Query qr = em.createQuery("from Discente c");
		return qr.getResultList();
	}
	
}
