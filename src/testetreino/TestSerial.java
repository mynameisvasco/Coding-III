package testetreino;

import java.io.FileNotFoundException;
import java.io.IOException;

public class TestSerial 
{
	public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, IOException
	{
		Clinica c = new Clinica("test");
		c.rescueClinica("clinica.bin");
		
		System.out.println(c.getNome());
		c.getMobiliario().toList().stream().forEach((m) -> System.out.println(m));
	}
}
