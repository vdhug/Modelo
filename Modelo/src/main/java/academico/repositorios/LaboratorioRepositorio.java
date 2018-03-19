package academico.repositorios;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import academico.entidades.Laboratorio;


public class LaboratorioRepositorio {

	private EntityManagerFactory emf;
	private EntityManager em;
	
	public LaboratorioRepositorio (){
		emf = Persistence.createEntityManagerFactory("AgendaLabJPA");
		em = emf.createEntityManager();
	}

	public void adicionar(Laboratorio laboratorio){
		System.out.println("Logging adicionar");
		em.getTransaction().begin();
		em.persist(laboratorio);
		em.getTransaction().commit();
	}
	public Laboratorio recuperar(int id){
		return em.find(Laboratorio.class, id);
	}
	public void atualizar(Laboratorio laboratorio){
		em.getTransaction().begin();
		em.merge(laboratorio);
		em.getTransaction().commit();
	}
	public void remover(Laboratorio laboratorio){
		em.getTransaction().begin();
		em.remove(laboratorio);
		em.getTransaction().commit();
	}	
	public void encerrar(){
		em.close();
		emf.close();
	}
	
	public List<Laboratorio> listar() {
		Query qr = em.createQuery("from Laboratorio c");
		return qr.getResultList();
	}
	
}
