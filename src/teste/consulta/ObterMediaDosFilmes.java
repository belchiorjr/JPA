package teste.consulta;

import infra.DAO;
import modelo.consulta.NotaFilme;

public class ObterMediaDosFilmes {
	public static void main(String[] args) {
		
		DAO<NotaFilme> dao = new DAO<>(NotaFilme.class);
		NotaFilme notaMediaFilmes = dao.consultaUm("obterMediaGeralDosFilmes");
		System.out.println("A nota geral dos filmes é: " +  notaMediaFilmes.getMedia());
		
		dao.fechar();
		
	}
}
