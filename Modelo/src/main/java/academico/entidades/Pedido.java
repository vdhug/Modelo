package academico.entidades;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Pedido {
	@Id
	private int id;
	@Column(nullable=false)
	private String status;
	@OneToMany(cascade={CascadeType.ALL}, orphanRemoval=true)
	// SE ACRESCENTAR ESSA LINHA, SERÁ CRIADO NA TABELA A CHAVE 
	// ESTRANGEIRA PARA pedido EM CADA item. ESSA É A FORMA DE 
	// OneToMany UNIDIRECIONAL SEM TABELA DE JUNÇÃO, O QUE ERA
	// IMPOSSÍVEL ATÉ A VERSÃO 2 DO JPA. EXCLUINDO ESSA ANOTAÇÃO,
	// AUTOMATICAMENTE, SERÁ USADA TABELA DE JUNÇÃO. TESTEM...
	@JoinColumn(name="PEDIDO_FK")
	private List<Item> itens = new ArrayList<Item>();
	
	public List<Item> getItens() {
		return itens;
	}
	public void setItens(List<Item> itens) {
		this.itens = itens;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public void addItem(Item i){
//		i.setPedido(this);		
		itens.add(i);
	}

	public void delItem(Item i){
//		i.setPedido(null);		
		itens.remove(i);
	}

	public String toString() {
		String strPedido = "Pedido [id=" + getId() + 
				", status='"+getStatus() + "'\n";
		for (Item item : itens) {
			strPedido = strPedido + "\t"+ item.toString() + "\n"; 
		}
		strPedido = strPedido + "]";
		return strPedido; 
	}
	
}
