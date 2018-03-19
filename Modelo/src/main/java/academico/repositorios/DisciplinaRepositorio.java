package academico.repositorios;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import academico.entidades.Curso;
import academico.entidades.Disciplina;


public class DisciplinaRepositorio {

	private EntityManagerFactory emf;
	private EntityManager em;
	
	public DisciplinaRepositorio (){
		emf = Persistence.createEntityManagerFactory("AgendaLabJPA");
		em = emf.createEntityManager();
	}

	public void adicionar(Disciplina disciplina){

		System.out.println("Logging persistence add");
		em.getTransaction().begin();
		em.persist(disciplina);
		em.getTransaction().commit();
	}
	public Disciplina recuperar(int id){
		return em.find(Disciplina.class, id);
	}
	
	public Curso recuperarCurso(int id){
		return em.find(Curso.class, id);
	}
	
	public void atualizar(Disciplina disciplina){
		em.getTransaction().begin();
		em.merge(disciplina);
		em.getTransaction().commit();
	}
	public void remover(Disciplina disciplina){
		em.getTransaction().begin();
		em.remove(disciplina);
		em.getTransaction().commit();
	}	
	public void encerrar(){
		em.close();
		emf.close();
	}
	
	public List<Disciplina> listar() {
		Query qr = em.createQuery("from Disciplina d");
		return qr.getResultList();
	}
	
}
