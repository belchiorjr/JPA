package teste.umpraum;

import infra.DAO;
import modelo.umpraum.Assento;
import modelo.umpraum.Cliente;

public class NovoClienteAssento1 {
	
	public static void main(String[] args) {
	
		Assento assento = new Assento("3BA");
		Cliente cliente = new Cliente("Filipe Lima Araújo", assento);
		
		DAO<Object> dao = new DAO<>();
		
		dao.abrirTransaction()
			.incluir(assento)
			.incluir(cliente)
			.fecharTransaction()
			.fechar();
			
	}
}
