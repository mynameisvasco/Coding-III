package aula9;

import java.util.Iterator;

import aula1.Date;
import aula1.Person;

public abstract class TestIterator 
{
	public static void main(String[] args) 
	{
		PeopleVector vp = new PeopleVector();
		for (int i=0; i<10; i++)
		vp.addPerson(new Person("Bebé no Vector "+i,
		 1000+i, Date.today()));
		Iterator<Person> vec = vp.iterator();
		while ( vec.hasNext() )
		System.out.println( vec.next() );
		PeopleList lp = new PeopleList();
		for (int i=0; i<10; i++)
		lp.addPerson(new Person("Bebé na Lista "+i,
		 2000+i, Date.today()));
		Iterator<Person> lista = lp.iterator();
		while ( lista.hasNext() )
		System.out.println( lista.next() );
	}
}