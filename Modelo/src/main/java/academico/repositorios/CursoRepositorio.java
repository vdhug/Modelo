package academico.repositorios;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import academico.entidades.Curso;

public class CursoRepositorio{

	private EntityManagerFactory emf;
	private EntityManager em;
	
	public CursoRepositorio (){
		emf = Persistence.createEntityManagerFactory("AcademicoJPA");
		em = emf.createEntityManager();
	}

	public void adicionar(Curso curso){
		em.getTransaction().begin();
		em.persist(curso);
		em.getTransaction().commit();
	}
	public Curso recuperar(int id){
		return em.find(Curso.class, id);
	}
	public void atualizar(Curso curso){
		em.getTransaction().begin();
		em.merge(curso);
		em.getTransaction().commit();
	}
	public void remover(Curso curso){
		em.getTransaction().begin();
		em.remove(curso);
		em.getTransaction().commit();
	}
	public List<Curso> listar() {
		Query qr = em.createQuery("from Curso c");
		return qr.getResultList();
	}

	public void encerrar(){
		em.close();
		emf.close();
	}
	
}
