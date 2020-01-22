package ap2019;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;

//Notas:
//Não altere o código apresentado
//Deve completar o código da alinea 2
//Comente o código com erros para garantir que vai executando parcialmente

public class P3_19 {	

	public static void main(String[] args) throws FileNotFoundException, IOException {
		Banco obanco = new Banco("PeDeMeia");
		PrintStream fl = new PrintStream(new File("resources/p3_1920L.txt"));
		alinea1(obanco, System.out); // executa e escreve na consola
		alinea2(obanco, fl); // executa e escreve no ficheiro
		fl.close();
	}

	public static void alinea1(Banco b, PrintStream out) {
		out.println("\nAlínea 1) ----------------------------------\n");
		
		Cliente c1 = new Individual("Manuel Lima", "281656798", TipoCliente.Balcao); 
		Cliente c2 = new Individual("Laura Marques", "301317832", TipoCliente.Online, "234500232" );
		Cliente c3 = new Individual("José Bento", "224456720", TipoCliente.Balcao, "234630535" );
		Cliente c4 = new Empresa("Lima & Irmao", "509434438", TipoCliente.Online, c1);
		Cliente c5 = new Empresa("Reboques Tudo o Bento Leva", "509782153", TipoCliente.Balcao, c3);
		
		//Conta bad = new eConta(c1); 							// Gera uma Excepção
		Conta contas[] = {	new Conta(c1), 	new eConta(c2),  new Conta(c3),  new eConta(c4),  new Conta(c5) };
		System.out.print(b.add(contas[0]) + ", ");  		// true
		System.out.print(b.add(contas[1]) + ", ");  		// true
		System.out.print(b.add(contas[2]) + ", ");  		// true
		System.out.print(b.add(contas[3]) + ", ");  		// true
		System.out.print(b.add(contas[4]) + ", ");  		// true
		System.out.print(b.add(contas[1]) + "\n");  		// false
		
		contas[0].add(new Credito(1000, "20191231"));
		contas[1].add(new Credito(2000, "20191231"));
		contas[2].add(new Credito(1400, "20191231"));
		contas[3].add(new Credito(4000, "20191231"));
		
		System.out.println("\n----- Listagem de contas -----");
		for (Iterator<Conta> ri = b.iterator(); ri.hasNext();)
			System.out.println(ri.next());	

	}
	
	private static void alinea2(Banco b, PrintStream out) throws IOException {
		List<String> fileLines = Files.readAllLines(Paths.get("resources/movimentos.txt"));
		for(Conta c : b.getContas())
		{
			for(String line : fileLines)
			{
				if(c.getNumero() == Integer.parseInt(line.split(";")[1]))
				{
					if(line.split(";")[0].equals("C"))
					{
						c.add(new Credito(Double.parseDouble(line.split(";")[2]), line.split(";")[3]));
					}
					else
					{
						c.add(new Debito(Double.parseDouble(line.split(";")[2]), line.split(";")[3]));
					}
				}
			}
		}
        // Adicione a seguir o código necessário para escrever para ficheiro a lista de contas com saldo negativo (usar java streams)
		out.println("----- Contas com saldo negativo -----");
		for(Conta c : b.getContas())
		{
			if(c.getSaldo() < 0)
			{
				out.println(c);
			}
		}
		
        // Adicione a seguir o código necessário para escrever para ficheiro o saldo total das contas eletrónicas (usar java streams)
		out.println("\n----- Saldo total das contas eletrónicas -----");
		for(Conta c : b.getContas())
		{
			if(c instanceof Eletronica)
			{
				out.println(c);
			}
		}

	}
}
