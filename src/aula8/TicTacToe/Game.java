package aula8.TicTacToe;

public class Game 
{
	/* HELPER >>>>>>>
	 * X and O have two different ids used in GameManager class, X -> 1, O -> 2
	 * Status have 3 different status, 0 -> Game didn't start, 1 -> Game on going, 2 -> Game finished
	 */
	
	private int firstToPlay;
	private int whoNow;
	private int whoNext;
	private int[][] board;
	private int winner;
	private int status;
	private int playsLeft;
	
	public Game(int firstToPlay) 
	{
		if(firstToPlay != 1 && firstToPlay != 2) 
		{
			System.out.println("Invalid argument supplied. Please use X or O");
			System.exit(0);
		}
		
		this.firstToPlay = firstToPlay;
		this.whoNow = firstToPlay;
		if(firstToPlay == 1)
		{
			this.whoNext = 2;
		}
		else
		{
			this.whoNext = 1;
		}
		this.playsLeft = 9;
		this.board = new int[3][3];
		this.winner = 0;
		this.status = 0;
	}

	public int getFirstToPlay() 
	{
		return firstToPlay;
	}
	
	public int[][] getBoard() 
	{
		return board;
	}
	
	public int getStatus() 
	{
		return status;
	}

	public int getWhoNow() 
	{
		return whoNow;
	}

	public int getWhoNext() 
	{
		return whoNext;
	}
	
	public int getWinner()
	{
		return winner;
	}
	
	public boolean checkWin()
	{
		//Vertical
		for(int x = 0; x < 3; x++)
		{
			if(this.board[x][0] == this.board[x][1] && this.board[x][0] == this.board[x][2] && this.board[x][0] != 0)
			{
				this.winner = this.board[x][1];
				System.out.println(this.board[x][1]);
				return true;
			}
		}
		
		//Horizontal
		for(int y = 0; y < 3; y++)
		{
			if(this.board[0][y] == this.board[1][y] && this.board[0][y] == this.board[2][y] && this.board[0][y] != 0)
			{
				this.winner = this.board[1][y];
				return true;
			}
		}
		
		//Diagonal 1
		if(this.board[0][0] == this.board[1][1] && this.board[0][0] == this.board[2][2] && this.board[0][0] != 0)
		{
			this.winner = this.board[1][1];
			return true;
		}
		
		//Diagonal 2
		if(this.board[2][0] == this.board[1][1] && this.board[2][0] == this.board[0][2] && this.board[2][0] != 0)
		{
			this.winner = this.board[1][1];
			return true;
		}
		
		return false;
	}
	
	public void play(int x, int y)
	{
		if(this.playsLeft == 0 && !this.checkWin())
		{
			this.winner = 0;
			return;
		}
		this.playsLeft--;
		this.status = 1;
		this.board[x][y] = this.getWhoNow();
		int tmp = this.whoNow;
		this.whoNow = this.whoNext;
		this.whoNext = tmp;
		this.checkWin();
	}
	
	public int getPlaysLeft() 
	{
		return playsLeft;
	}

	public void reset(int firstToPlay)
	{		
		this.firstToPlay = firstToPlay;
		this.whoNow = firstToPlay;
		
		if(firstToPlay == 1)
		{
			this.whoNext = 2;
		}
		else
		{
			this.whoNext = 1;
		}
		
		this.board = new int[3][3];
		this.playsLeft = 9;
		this.winner = 0;
		this.status = 0;
		
	}
	
	public static int figToId(String fig)
	{
		if(fig.equals("X")) return 1;
		if(fig.equals("O")) return 2;
		else return -1;
	}
	
	public static String idToFig(int id)
	{
		if(id == 1) return "X";
		if(id == 2) return "O";
		else return "";
	}
	
}
