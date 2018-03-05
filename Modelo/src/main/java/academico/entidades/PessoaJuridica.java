package academico.entidades;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Juridica")
public class PessoaJuridica extends Pessoa{

	private int cnpj;

	public int getCnpj() {
		return cnpj;
	}

	public void setCnpj(int cnpj) {
		this.cnpj = cnpj;
	}

	@Override
	public String getDoc() {
		return "CNPJ: " + getCnpj();
	}
	
}
