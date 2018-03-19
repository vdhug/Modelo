package academico.repositorios;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import academico.entidades.Usuario;


public class UsuarioRepositorio {

	private EntityManagerFactory emf;
	private EntityManager em;
	
	public UsuarioRepositorio (){
		emf = Persistence.createEntityManagerFactory("AgendaLabJPA");
		em = emf.createEntityManager();
	}

	public void adicionar(Usuario usuario){
		em.getTransaction().begin();
		em.persist(usuario);
		em.getTransaction().commit();
	}
	public Usuario recuperar(int id){
		return em.find(Usuario.class, id);
	}
	public void atualizar(Usuario usuario){
		em.getTransaction().begin();
		em.merge(usuario);
		em.getTransaction().commit();
	}
	public void remover(Usuario usuario){
		em.getTransaction().begin();
		em.remove(usuario);
		em.getTransaction().commit();
	}	
	public void encerrar(){
		em.close();
		emf.close();
	}
	
	public List<Usuario> listar() {
		Query qr = em.createQuery("from Usuario u");
		return qr.getResultList();
	}
	
}
