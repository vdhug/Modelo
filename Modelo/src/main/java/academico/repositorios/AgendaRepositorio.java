package academico.repositorios;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import academico.entidades.Agenda;
import academico.entidades.Docente;
import academico.entidades.Laboratorio;



public class AgendaRepositorio {

	private EntityManagerFactory emf;
	private EntityManager em;
	
	public AgendaRepositorio (){
		emf = Persistence.createEntityManagerFactory("AgendaLabJPA");
		em = emf.createEntityManager();
	}

	public void adicionar(Agenda agenda){
		em.getTransaction().begin();
		em.persist(agenda);
		em.getTransaction().commit();
	}
	public Agenda recuperar(int id){
		return em.find(Agenda.class, id);
	}
	
	public Docente recuperarDocente(int id){
		return em.find(Docente.class, id);
	}
	
	public Laboratorio recuperarLaboratorio(int id){
		return em.find(Laboratorio.class, id);
	}
	
	public List<Agenda> listar() {
		Query qr = em.createQuery("from Agenda c");
		return qr.getResultList();
	}
	
	public void atualizar(Agenda agenda){
		em.getTransaction().begin();
		em.merge(agenda);
		em.getTransaction().commit();
	}
	public void remover(Agenda agenda){
		em.getTransaction().begin();
		em.remove(agenda);
		em.getTransaction().commit();
	}	
	public void encerrar(){
		em.close();
		emf.close();
	}
	
}
