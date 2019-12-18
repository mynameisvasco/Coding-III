package aula10;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;
import java.lang.Comparable;

public class BinarySearchTree<T extends Comparable<? super T>> implements Iterable<T> 
// o elemento do tipo T deve ser comparável para efectuar pesquisas 
// mas como pode herdar a implementação de compareTo() é mais correcto 
// usar <? super T>
{
	private static class BSTNode<T> 
	{ 
		T element;
		BSTNode<T> left; 
		BSTNode<T> right;
		BSTNode(T theElement) 
		{ 
			element = theElement;
			left = right = null;
		} 
	}
	
	private BSTNode<T> root; 
	private int numNodes;
	
	public 	BinarySearchTree() 
	{ 
		root = null; 
		numNodes = 0;
	}
	

	public int size() 
	{
		return numNodes;
	}
	
	public void insert(T value) 
	{ 
		if(this.contains(value)) return;
		root = insert(value, root);
	}
	
	private BSTNode<T> insert(T value, BSTNode<T> root)
	{
		if(root == null) 
		{
			numNodes++;
			root = new BSTNode<T>(value);
		}
		if(root.element.compareTo(value) == -1)
		{
			root.left = insert(value, root.left);
		}
		else if(root.element.compareTo(value) == 1)
		{
			root.left = insert(value, root.right);
		}
		
		return root;
	}
	
	public void remove(T value) 
	{ 
		if(root == null) throw new NullPointerException();
		if(!this.contains(value)) throw new NoSuchElementException();
		numNodes--;
		root = remove(value, root);
	}
	
	private BSTNode<T> remove(T value, BSTNode<T> root)
	{
		if(root != null)
		{			
			if(root.element.equals(value))
			{
				root = null;
			}
			else if(root.element.compareTo(value) == -1)
			{
				root.left = remove(value, root.left);
			}
			else if(root.element.compareTo(value) == 1)
			{
				root.right = remove(value, root.right);
			}
		}		
		return root;
	}
	
	public boolean contains(T value) 
	{
		Iterator<T> it = iterator();
		boolean exists = false;
		while(it.hasNext()) 
		{
			if(((T)it.next()).equals(value)) 
			{
				return true;
			}
		}
		return exists;
	}
	
	public Iterator<T> iterator() 
	{
		return new BSTIterator<T>(root);
	}
	
	public class BSTIterator<E> implements Iterator<E> 
	{
		Stack<BSTNode<E>> stack;
	 
		public BSTIterator(BSTNode<E> root) 
		{
			stack = new Stack<BSTNode<E>>();
			while (root != null) 
			{
				stack.push(root);
				root = root.left;
			}
		}
	 
		public boolean hasNext() 
		{
			return !stack.isEmpty();
		}
	 
		public E next() 
		{
			BSTNode<E> node = stack.pop();
			E top = node.element;
			if (node.right != null) 
			{
				node = node.right;
				while (node != null) 
				{
					stack.push(node);
					node = node.left;
				}
			}
			return top;
		}
	}
	
}