package teste.consulta;

import java.util.List;

import infra.DAO;
import modelo.muitosparamuitos.Ator;
import modelo.muitosparamuitos.Filme;

public class ObterFilmes {
	public static void main(String[] args) {

		DAO<Filme> dao = new DAO<>(Filme.class);
		List<Filme> filmes = dao.consulta("obterFilmesComNotaMaiorQue", "nota", 8.0);
		
		
		for(Filme filme: filmes) {
			System.out.println(filme.getNome() +  " Nota: " + filme.getNota());
			
			for(Ator ator: filme.getAtores()) {
				System.out.println(ator.getNome());
			}
		}
		
	}
}
