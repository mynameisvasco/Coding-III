package aula10;

public class TestBinarySearchTree 
{
	public static void main(String[] args)
	{
		BinarySearchTree<Double> bst = new BinarySearchTree<Double>();
		
		for(int i = 0; i < 10; i++)
		{
			double n = Math.random() * 30 + i;
			bst.insert(n);
		}
		
		for(Double d : bst)
		{
			System.out.println(d);
		}
		
		System.out.println(bst.size());
	}
}
