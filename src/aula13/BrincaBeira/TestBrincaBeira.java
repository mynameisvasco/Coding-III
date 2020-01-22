package aula13.BrincaBeira;

public class TestBrincaBeira 
{
	public static void main(String[] args)
	{
		BrincaBeira company = new BrincaBeira();
		
		company.addWorker("Vasco Sousa");
		company.addWorker("José Carvalho");
		company.addWorker("Daniel Almeida");
		
		System.out.println("Company workers");
		System.out.println("-----------------------");
		for(String worker : company.getWorkers())
		{
			System.out.println(worker);
		}
		
		company.addToy("Carro");
		company.addToy("Ursinho");
		company.addToy("Ursinho");
		
		System.out.println("\nCompany toys");
		System.out.println("-----------------------");
		for(String toy : company.getToys())
		{
			System.out.println(toy);
		}
		
		company.giftToy();
		company.giftToy();
		System.out.println("\nGifted Toys");
		System.out.println("-----------------------");
		company.getGiftedToys().forEach((k,v) -> System.out.println(k + " received a " + v));
		
		company.awardTicket();
		company.awardTicket();
		company.awardTicket();
		System.out.println("\nAwarded tickets");
		System.out.println("-----------------------");
		for(String worker : company.getAwardedTickets())
		{
			System.out.println(worker + " was awarded with a football ticket");
		}
	}
}
