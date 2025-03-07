package app;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {

		File file = new File("E:\\projetos\\desafio_sistema-de-cadastros\\formulario.txt");
		Scanner sc = null;

		try {
			sc = new Scanner(file);
			while (sc.hasNextLine()) {
				System.out.println(sc.nextLine());
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		} finally {
			if (sc != null) {
				sc.close();
			}
		}

		sc = new Scanner(System.in);
		System.out.print("\nNome: ");
		String nomeCompleto = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.nextLine();
		System.out.print("Idade: ");
		int idade = sc.nextInt();
		sc.nextLine();
		System.out.print("Altura: ");
		double altura = sc.nextDouble();
		sc.close();

		String[] lines = new String[] { nomeCompleto, email, Integer.toString(idade), Double.toString(altura) };

		String path = "E:\\projetos\\desafio_sistema-de-cadastros\\usuario.txt";

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
			for (String line : lines) {
				bw.write(line);
				bw.newLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}