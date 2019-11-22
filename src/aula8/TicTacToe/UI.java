package aula8.TicTacToe;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

public class UI implements ActionListener
{
	JFrame mainFrame;
	static JToggleButton[][] buttons;
	private Game game;
	
	public UI(String firstToPlay)
	{
		game = new Game(Game.figToId(firstToPlay));
		this.mainFrame = new JFrame("Tic-Tac-Toe");
		this.init();
	}
	
	public void init()
	{
		buttons = new JToggleButton[3][3];
		this.mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.mainFrame.setSize(500,500);
		this.initButtons();
		this.mainFrame.setVisible(true);
	}
	
	public void initButtons()
	{
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.setLayout(new GridLayout(3,3));
		
		for(int x = 0; x < 3; x++)
		{
			for(int y = 0; y < 3; y++)
			{				
				JToggleButton btn = new JToggleButton();
				btn.addActionListener((ActionListener) this);
				UI.buttons[x][y] = btn;
				buttonsPanel.add(btn);
			}
		}
		
		buttonsPanel.setOpaque(true);
		this.mainFrame.add(buttonsPanel);
	}
	
	public int[] getButtonArrayPos(JToggleButton btn)
	{
		for(int x = 0; x < 3; x++)
		{
			for(int y = 0; y < 3; y++)
			{
				if(btn == UI.buttons[x][y])
				{
					return new int[] {x,y};
				}
			}
		}
		return null;
	}
	
	public void actionPerformed(ActionEvent event) 
	{
		JToggleButton btn = (JToggleButton) event.getSource();
		btn.setEnabled(false);
		
		
		if(game.getWhoNow() == 1)
		{
			//btn.setText("X");
			btn.setIcon(new ImageIcon("resources/xIcon.png"));
			
		}
		else
		{
			//btn.setText("O");
			btn.setIcon(new ImageIcon("resources/oIcon.png"));
		}
		
		this.game.play(this.getButtonArrayPos(btn)[0], this.getButtonArrayPos(btn)[1]);

		if(this.game.getPlaysLeft() == 0)
		{
			JOptionPane.showMessageDialog(mainFrame, "It is a draw!");
			this.game.reset(this.game.getWhoNow());
			
			//Reset buttons
			for(int x = 0; x < 3; x++)
			{
				for(int y = 0; y < 3; y++)
				{
					UI.buttons[x][y].setIcon(null);
					UI.buttons[x][y].setSelected(false);	
					UI.buttons[x][y].setEnabled(true);
				}
			}
		}
		if(this.game.checkWin())
		{
			JOptionPane.showMessageDialog(mainFrame, Game.idToFig(this.game.getWinner()) + " just won the game!");
			this.game.reset(this.game.getWinner());
			
			//Reset buttons
			for(int x = 0; x < 3; x++)
			{
				for(int y = 0; y < 3; y++)
				{
					UI.buttons[x][y].setIcon(null);
					UI.buttons[x][y].setSelected(false);		
					UI.buttons[x][y].setEnabled(true);
				}
			}
		}
	}

}
