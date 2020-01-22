package testetreino;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class p31415ap1 {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		Cadeira cd1 = new Cadeira("Elite-2", 2034, Mobiliario.Tipo.Sintetico, Cadeira.TipoCadeira.Escritorio, 0.9, 1);
		CadeiraRodas cd2 = new CadeiraRodas("Mobileplus", 3211, Mobiliario.Tipo.Metal, Cadeira.TipoCadeira.Escritorio,
				0.1, 4, 4, false);

		cd2.setTipo(TipoTransporte.MobilidadeReduzida);
		Cama c1 = new Cama("Fofinha", 4323, Mobiliario.Tipo.Madeira, 1.90, 1.10, true);
		CamaArticulada ca1 = new CamaArticulada("MaxFlex2000", 4124, Mobiliario.Tipo.Metal, 1.90, 1.20, true, true);

		Marquesa m1 = new Marquesa("Ix20", 1234, Mobiliario.Tipo.Metal, 1.90, 0.9, true, false);
		Maca ma1 = new Maca("Speedx2", 9232, Mobiliario.Tipo.Metal, 2.00, 0.8, false, 2);
		ma1.setTipo(TipoTransporte.Urgente);

		Clinica cl = new Clinica("Boa Saúde");

		System.out.println("\n---------------------------- Insercao Mobiliario --------------------------------------");
		System.out.print(cl.addMobiliario(cd1) + ", ");// true
		System.out.print(cl.addMobiliario(cd1) + ", ");// false
		System.out.print(cl.addMobiliario(cd2) + ", ");// true
		System.out.print(cl.addMobiliario(c1) + ", ");// true
		System.out.print(cl.addMobiliario(ca1) + ", ");// true
		System.out.print(cl.addMobiliario(m1) + ", ");// true
		System.out.print(cl.addMobiliario(ma1) + ", ");// true

		System.out.println(
				"\n\n------------------------- Listagem de todo o Mobiliario -------------------------------\n");
		for (MyRangeIterator<Mobiliario> r1 = (MyRangeIterator<Mobiliario>) cl.iterator(); r1.hasNext();)
			System.out.println(r1.next() + "\n");
		
		cl.removeMobiliario(cd1);

		System.out.println(
				"\n------------------------ Listagem de Mobiliario de Transporte -----------------------------");
		List<Transporte> lo = cl.listTransportes();
		for (Iterator<Transporte> ri = lo.iterator(); ri.hasNext();) {
			Transporte tp = ri.next();
			System.out.println("  Elemento: " + tp.getClass().getSimpleName() + " para transporte " + tp.getTipoTransporte());
		}
		cl.saveClinica("clinica.bin");
		cl.rescueClinica("clinica.bin");

	}
}
