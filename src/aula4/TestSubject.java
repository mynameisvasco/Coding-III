package aula4;

import aula3.Student;
import aula1.Date;
import aula3.Fellow;

public class TestSubject 
{
	public static void main(String[] args) 
	{
		Student est1 = new Student("Andreia", 9855678, new Date(18, 7, 1974));
		Student est2 = new Student("Monica", 75266454, new Date(11, 8, 1978));
		Student est3 = new Student("Jose", 85265426, new Date(15, 2, 1976));
		Student est4 = new Student("Manuel", 85153442, new Date(1, 3, 1973));
		Fellow bls1 = new Fellow("Maria", 8976543, new Date(12, 5, 1976));
		Fellow bls2 = new Fellow("Xico", 872356522, new Date(21, 4, 1975));
		Fellow bls3 = new Fellow("Duarte", 32423512, new Date(6, 1, 1976));
		bls1.setFellowship(745);
		bls2.setFellowship(845);
		bls3.setFellowship(745);
		Teacher pf1 = new Teacher("Jose Manuel", 11223344, new Date(11, 9, 1969));
		Subject dis = new Subject("P5", "Informatica", 6, pf1);
		dis.addStudent(est1);
		dis.addStudent(est2);
		dis.addStudent(bls1);
		
		if (dis.checkStudent(est3.getNmec()))
		{	
			System.out.println("\n" + est3
			+ " \n\t-> ESTÁ inscrito na Disciplina");
		}
		else
			System.out.println("\n" + est3
			+ " \n\t-> NÃO ESTÁ inscrito na Disciplina");
			
		System.out.println("\nNº de Alunos Inscritos: " + dis.getStudentsNum());
		dis.addStudent(est3);
		dis.addStudent(bls2);
		dis.addStudent(est4);
		dis.addStudent(bls3);
		
		if (!dis.addStudent(bls3))
			System.out.println(bls3.getNmec() + ", " + bls3.getName()
			+ " já está inscrito nesta disciplina!");
		
		if (dis.delStudent(bls2.getNmec()))
			System.out.println(bls2.getName() + " Removido!");
			
		System.out.println("\nNº de Alunos Inscritos: " + dis.getStudentsNum());
		System.out.println(dis + "\n");
		System.out.println("\n Listagem de Students:");
		for (Student e : dis.getStudents())
			System.out.println(e);
		System.out.println("\n Listagem de Bolseiros:");
		for (Student e : dis.getStudents("Fellow"))
			System.out.println(e);
	}
}