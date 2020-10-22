package teste.basico;

import infra.DAO;
import modelo.basico.Produto;

public class NovoProduto {
	public static void main(String[] args) {
		DAO<Produto> dao = new DAO<>(Produto.class);
		
		Produto produto = new Produto("Caderno Capa Dura", 20.45, "Caderno Capa Dura Fielight.");
		
		/*dao.abrirTransaction();
		dao.incluir(produto);
		dao.fecharTransaction();
		dao.fechar();*/
		//dao.abrirTransaction().incluir(produto).fecharTransaction().fechar();
		
		dao.incluirAtomico(produto).fechar();
		
		System.out.println("Id do Produto inserido: " +  produto.getId());;
	}
}
