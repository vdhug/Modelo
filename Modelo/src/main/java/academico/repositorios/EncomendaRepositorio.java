package academico.repositorios;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import academico.entidades.Curso;
import academico.entidades.Encomenda;

public class EncomendaRepositorio {

	private EntityManagerFactory emf;
	private EntityManager em;
	
	public EncomendaRepositorio (){
		emf = Persistence.createEntityManagerFactory("AcademicJPA");
		em = emf.createEntityManager();
	}

	public void adicionar(Encomenda encomenda){
		em.getTransaction().begin();
		em.persist(encomenda);
		em.getTransaction().commit();
	}
	public Curso recuperar(int id){
		return em.find(Curso.class, id);
	}
	public void atualizar(Encomenda encomenda){
		em.getTransaction().begin();
		em.merge(encomenda);
		em.getTransaction().commit();
	}
	public void remover(Encomenda encomenda){
		em.getTransaction().begin();
		em.remove(encomenda);
		em.getTransaction().commit();
	}	
	public void encerrar(){
		em.close();
		emf.close();
	}
	
}
