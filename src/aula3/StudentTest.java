package aula3;

import aula1.Date;

public class StudentTest 
{
	public static void main(String[] args)
	{
		Student est = new Student ("Andreia", 9855678, new Date(18, 7, 1974), "MIECT");
		Fellow bls = new Fellow ("Maria", 8976543, new Date(11, 5, 1976), "MIEET", new Date(15,2, 2020));
		bls.setFellowship(745);
		
		System.out.println("Estudante:" + est.getName());
		System.out.println(est);

		System.out.println("Bolseiro:" + bls.getName() + ", NMec: " + bls.getNmec()
		+ ", Bolsa:" + bls.getFellowship());
		System.out.println(bls);
	}
}
