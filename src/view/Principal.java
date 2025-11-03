package view;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import controller.FifaController;

public class Principal {
	public static void main(String[] args) {
		FifaController newSearch = new FifaController();
		String path = "";
		String file = "";
		Stack<String> stackPlayers = new Stack<>();
		List<String> listPlayers = new LinkedList<>();
		
		path = "C:/TEMP/";
		file = "data.csv";
		
		try {
			stackPlayers = newSearch.empilhaBrasileiros(path, file);
			newSearch.desempilhaBonsBrasileiros(stackPlayers);
			
			System.out.println("\n");
			
			listPlayers = newSearch.listaRevelacoes(path, file);
			newSearch.buscaListaBonsJovens(listPlayers);
		} catch (IOException e) {
			System.err.println("I/O Error: ");
			System.err.println(e.getMessage());
		}
	}
}
