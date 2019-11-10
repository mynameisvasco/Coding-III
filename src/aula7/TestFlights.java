package aula7;

import java.io.IOException;
import java.util.LinkedList;

public class TestFlights 
{
	public static void main(String[] args) throws IOException
	{
		LinkedList<Fly> flights = Fly.loadFromFile("src/aula7/voos.txt", "src/aula7/companhias.txt");
		Fly.saveToFile(flights, "src/aula7/Infopublico.txt");
		LinkedList<Company> companies = Company.loadFromFile("src/aula7/companhias.txt");
		
		Company.avarageDelaySaveToFile(companies, flights, "src/aula7/atrasos_medios_por_companhia.txt");
		Fly.saveCitiesToFile(flights, "src/aula7/cidades.txt");
	}
}
