package academico.repositorios;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import academico.entidades.Curso;


public class CursoRepositorio {

	private EntityManagerFactory emf;
	private EntityManager em;
	
	public CursoRepositorio (){
		emf = Persistence.createEntityManagerFactory("AgendaLabJPA");
		em = emf.createEntityManager();
	}
	
	public void adicionar(Curso curso){
		System.out.println("Adicionar");
		em.getTransaction().begin();
		em.persist(curso);
		em.getTransaction().commit();
	}
	public Curso recuperar(int id){
		return em.find(Curso.class, id);
	}
	// ESSAS NOSSAS CONSULTAS SÃO BEM SIMPLES, NEM PRECISARIA USAR O Criteria
	// SÓ UMA LINHA COM find JÁ RESOLVERIA... +/- COMO USAR UM CANHÃO 
	// MATAR UMA MOSCA..... ;-)
	public Curso recuperarPeloCodigo(int codigo) {
	    CriteriaBuilder builder = emf.getCriteriaBuilder();
	    CriteriaQuery<Curso> criteria = builder.createQuery(Curso.class);
	    Root<Curso> from = criteria.from(Curso.class);
	    criteria.select(from);
		criteria.where(builder.equal(from.get("codigo"), codigo));
	    TypedQuery<Curso> typed = em.createQuery(criteria);
	    try {
	        return typed.getSingleResult();
	    } catch (final NoResultException nre) {
	        return null;
	    }
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
	public void encerrar(){
		em.close();
		emf.close();
	}
	
	public List<Curso> listar() {
		Query qr = em.createQuery("from Curso c");
		return qr.getResultList();
	}
	
}
