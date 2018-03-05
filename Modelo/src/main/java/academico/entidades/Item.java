package academico.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Item {    
	@Id
	private int id;
	@Column(nullable=false)
	private Long quantidade;
//	@ManyToOne(cascade={CascadeType.ALL})
//	@JoinColumn(name="PEDIDO_FK")
//	private Pedido pedido;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Long getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Long quantidade) {
		this.quantidade = quantidade;
	}
//	public Pedido getPedido() {
//		return pedido;
//	}
//	public void setPedido(Pedido pedido) {
//		this.pedido = pedido;
//	}
//	
	public String toString() {
		return "Item [id=" + getId()+", "
				+ "quantidade="+getQuantidade()+"]";
	}
}
