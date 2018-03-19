package academico.repositorios;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import academico.entidades.Escola;


public class EscolaRepositorio {

	private EntityManagerFactory emf;
	private EntityManager em;
	
	public EscolaRepositorio() {
		emf = Persistence.createEntityManagerFactory("AcademicoJPA");
		em = emf.createEntityManager();
	}

	public void adicionar(Escola escola){
		em.getTransaction().begin();
		em.persist(escola);
		em.getTransaction().commit();
	}
	public Escola recuperar(int id){
		return em.find(Escola.class, id);
	}
	public void atualizar(Escola escola){
		em.getTransaction().begin();
		em.merge(escola);
		em.getTransaction().commit();
	}
	public void remover(Escola escola){
		em.getTransaction().begin();
		em.remove(escola);
		em.getTransaction().commit();
	}
	public List<Escola> listar() {
		Query qr = em.createQuery("from Escola e");
		return qr.getResultList();
	}

	public void encerrar(){
		em.close();
		emf.close();
	}
}
