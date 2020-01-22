package testetreino;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Clinica 
{
	private String nome;
	private ListaGeneric<Mobiliario> mobiliario;
	
	public Clinica(String nome)
	{
		this.nome = nome;
		this.mobiliario = new ListaGeneric<Mobiliario>();
	}

	public boolean addMobiliario(Mobiliario m)
	{
		return this.mobiliario.addElem(m);
	}
	
	public boolean removeMobiliario(Mobiliario m)
	{
		return this.mobiliario.removeElem(m);
	}
	
	public String getNome() {
		return nome;
	}

	public ListaGeneric<Mobiliario> getMobiliario() {
		return mobiliario;
	}
	
	public void saveClinica(String filename) throws FileNotFoundException, IOException
	{
		FileOutputStream f = new FileOutputStream("src/testetreino/" + filename);
		ObjectOutputStream out = new ObjectOutputStream(f);
		out.writeUTF(this.nome);
		out.writeObject(this.mobiliario);
		out.close();
		f.close();
	}
	
	@SuppressWarnings("unchecked")
	public void rescueClinica(String filename) throws FileNotFoundException, IOException, ClassNotFoundException
	{
		FileInputStream f = new FileInputStream("src/testetreino/" + filename);
		ObjectInputStream in = new ObjectInputStream(f);
		this.nome = in.readUTF();
		this.mobiliario = (ListaGeneric<Mobiliario>) in.readObject();
	}
	
	public MyRangeIterator<Mobiliario> iterator()
	{
		return new Iterator();
	}
	
	public List<Transporte> listTransportes()
	{
		List<Transporte> t = new ArrayList<Transporte>();
		this.mobiliario.toList().stream().forEach(m -> {
			if(m instanceof Transporte)
			{
				t.add((Transporte) m);
			}
		});
		return t;
	}
	
	private class Iterator implements MyRangeIterator<Mobiliario>
	{
		public Iterator()
		{
			
		}
		int k = 0;
		public boolean hasNext() 
		{
			try
			{				
				mobiliario.get(k + 1);
				return true;
			}
			catch(IndexOutOfBoundsException e)
			{
				return false;
			}
		}

		public Mobiliario next() 
		{
			if(this.hasNext())
			{
				Mobiliario o = mobiliario.get(k);
				k++;
				return o;
			}
			else
			{
				return null;
			}
		}
		
	}
}