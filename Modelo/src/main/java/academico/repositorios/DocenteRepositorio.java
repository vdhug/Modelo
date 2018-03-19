package academico.repositorios;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import academico.entidades.Docente;


public class DocenteRepositorio {

	private EntityManagerFactory emf;
	private EntityManager em;
	
	public DocenteRepositorio (){
		emf = Persistence.createEntityManagerFactory("AgendaLabJPA");
		em = emf.createEntityManager();
	}

	public void adicionar(Docente docente){
		em.getTransaction().begin();
		em.persist(docente);
		em.getTransaction().commit();
	}
	public Docente recuperar(int id){
		return em.find(Docente.class, id);
	}
	public void atualizar(Docente docente){
		em.getTransaction().begin();
		em.merge(docente);
		em.getTransaction().commit();
	}
	public void remover(Docente docente){
		em.getTransaction().begin();
		em.remove(docente);
		em.getTransaction().commit();
	}	
	public void encerrar(){
		em.close();
		emf.close();
	}
	
	public List<Docente> listar() {
		Query qr = em.createQuery("from Docente c");
		return qr.getResultList();
	}
	
}
