package academico.repositorios;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import academico.entidades.Pedido;

public class PedidoRepositorio {

	private EntityManagerFactory emf;
	private EntityManager em;
	
	public PedidoRepositorio (){
		emf = Persistence.createEntityManagerFactory("AcademicJPA");
		em = emf.createEntityManager();
	}

	public void adicionar(Pedido pedido){
		em.getTransaction().begin();
		em.persist(pedido);
		em.getTransaction().commit();
	}
	public Pedido recuperar(int id){
		return em.find(Pedido.class, id);
	}
	@SuppressWarnings("unchecked")
	public List<Pedido> recuperarTodos(){
		Query query = em.createQuery("SELECT p FROM Pedido p");
		return query.getResultList();
	}
	@SuppressWarnings("unchecked")
	public List<Pedido> recuperarPorStatus(String status){
		Query query = em.createQuery("SELECT p FROM Pedido p "
				+ "WHERE p.status LIKE :status");
		query.setParameter("status", "%" + status + "%");
		
		return query.getResultList();
	}
	public void atualizar(Pedido pedido){
		em.getTransaction().begin();
		em.merge(pedido);
		em.getTransaction().commit();
	}
	public void remover(Pedido pedido){
		em.getTransaction().begin();
		em.remove(pedido);
		em.getTransaction().commit();
	}	
	public void encerrar(){
		em.close();
		emf.close();
	}
	
}
