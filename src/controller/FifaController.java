package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class FifaController implements IFifaController {
	private boolean validateFile(File file) {
		return file.exists() && file.isFile();
	}
	
	@Override
	public Stack<String> empilhaBrasileiros(String caminho, String nome) throws IOException {
		File file = new File(caminho, nome);
		Stack<String> brazilianPlayers = new Stack<>();

		if (validateFile(file)) {
			FileInputStream fileInput = new FileInputStream(file); // open file
			InputStreamReader reader = new InputStreamReader(fileInput); // read file
			BufferedReader buffer = new BufferedReader(reader); // put it inside a buffer

			String line = buffer.readLine(); // put all the buffered lines inside a String
			
			while (line != null) {
				if (!line.contains("Photo")) {
					String[] player = line.split(",");

					if (player[5].equals("Brazil")) {
						brazilianPlayers.push(line);
					}
				}
				line = buffer.readLine();

			}
			buffer.close(); // close the buffer
			reader.close(); // close the file reader
			fileInput.close(); // close the file
		} else {
			throw new IOException("Invalid file: " + nome);
		}

		return brazilianPlayers;

	}

	@Override
	public void desempilhaBonsBrasileiros(Stack<String> pilha) throws IOException {
		Stack<String> toPrint = pilha;
		System.out.println("===========================");
		System.out.printf("%-18s %s%n", "NAME", "OVERALL");
		System.out.println("===========================");
		while (!toPrint.isEmpty()) {
			String player = toPrint.pop();
			String[] playerFormated = player.split(",");
			if (Integer.parseInt(playerFormated[7]) > 80) {
				System.out.printf("%-20s %s%n", playerFormated[2], playerFormated[7]);
			}
		}
	}

	@Override
	public List<String> listaRevelacoes(String caminho, String nome) throws IOException {
		List<String> revelations = new LinkedList<>();
		File file = new File(caminho, nome);
		
		if (validateFile(file)) {
			FileInputStream fileInput = new FileInputStream(file); // open file
			InputStreamReader reader = new InputStreamReader(fileInput); // read file
			BufferedReader buffer = new BufferedReader(reader); // put it inside a buffer

			String line = buffer.readLine(); // put all the buffered lines inside a String
			while (line != null) {
				if (!line.contains("Photo")) {
					String[] player = line.split(",");
					
					if (Integer.parseInt(player[3]) <= 20) {
						revelations.add(line);
					}
				}
				line = buffer.readLine();

			}
			buffer.close(); // close the buffer
			reader.close(); // close the file reader
			fileInput.close(); // close the file
		} else {
			throw new IOException("Invalid file: "+nome);
		}
		
		return revelations;
	}

	@Override
	public void buscaListaBonsJovens(List<String> lista) throws IOException {
		List<String> toPrint = lista;		
		
		System.out.println("======================================================");
		System.out.printf("%-18s %-19s %s%n", "NAME", "AGE", "OVERALL");
		System.out.println("======================================================");
		for (String line : toPrint) {
			String[] playerFormated = line.split(",");
			if (Integer.parseInt(playerFormated[7]) > 80) {
				System.out.printf("%-20s %-20s %s%n", playerFormated[2], playerFormated[3], playerFormated[7]);
			}
		}
	}

}
