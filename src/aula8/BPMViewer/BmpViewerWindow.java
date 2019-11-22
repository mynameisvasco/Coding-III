package aula8.BPMViewer;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

public class BmpViewerWindow implements ActionListener
{
	private Bitmap bmp;
	private JFrame mainFrame;
	private JMenuBar menuBar;
	private JMenu fileMenu;
	private JMenuItem openMenuItem;
	private JMenuItem saveMenuItem;
	private JMenuItem saveAsMenuItem;
	private PanelImage panelImage;
	private JPanel buttonsPanel;
	private JButton horizontalFlipBtn;
	private JButton verticalFlipBtn;
	private JButton resizeBtn;
	private JFileChooser fileChooser;
	private File file;
	
	public BmpViewerWindow()
	{
		mainFrame = new JFrame("BmpViewer");
		mainFrame.setLayout(new BorderLayout(100,100));
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setSize(1280,720);
		this.initMenu();
		this.initButtons();
		this.initPanelImage();
		mainFrame.setVisible(true);
	}
	
	public void initMenu()
	{
		menuBar = new JMenuBar();
		fileMenu = new JMenu("Files");
		
		openMenuItem = new JMenuItem("Open");
		openMenuItem.addActionListener(this);
		
		saveMenuItem = new JMenuItem("Save");
		saveMenuItem.addActionListener(this);
		
		saveAsMenuItem = new JMenuItem("Save As...");
		saveAsMenuItem.addActionListener(this);
		
		fileMenu.add(openMenuItem);
		fileMenu.add(saveMenuItem);
		fileMenu.add(saveAsMenuItem);
		menuBar.add(fileMenu);
		
		mainFrame.add(menuBar, BorderLayout.PAGE_START);
	}
	
	public void initPanelImage()
	{	
		if(bmp != null)
		{
		    Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();

			panelImage = new PanelImage(bmp.getData(), bmp.getBitmapInfoHeader().getWidth(), bmp.getBitmapInfoHeader().getHeight()); 
			mainFrame.add(Box.createRigidArea(new Dimension((int) ((dimension.getWidth() - mainFrame.getWidth()) / 2) + bmp.getBitmapInfoHeader().getWidth() /4, (int) ((dimension.getHeight() - mainFrame.getHeight()) / 2))), BorderLayout.WEST);
			mainFrame.add(panelImage, BorderLayout.CENTER);
			mainFrame.revalidate();
			mainFrame.repaint();
			
		}
	}
	
	public void refreshPanelImage()
	{
		if(bmp != null)
		{
			mainFrame.remove(panelImage);
			Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
			panelImage = new PanelImage(bmp.getData(), bmp.getBitmapInfoHeader().getWidth(), bmp.getBitmapInfoHeader().getHeight()); 
			mainFrame.add(Box.createRigidArea(new Dimension((int) ((dimension.getWidth() - mainFrame.getWidth()) / 2) + bmp.getBitmapInfoHeader().getWidth() /4, (int) ((dimension.getHeight() - mainFrame.getHeight()) / 2))), BorderLayout.WEST);
			mainFrame.add(panelImage, BorderLayout.CENTER);
			mainFrame.revalidate();
			mainFrame.repaint();
		}
	}
	
	public void initButtons()
	{
		buttonsPanel = new JPanel();

		horizontalFlipBtn = new JButton("Flip Horizontal");
		horizontalFlipBtn.addActionListener(this);
		
		verticalFlipBtn = new JButton("Flip Vertical");
		verticalFlipBtn.addActionListener(this);
		
		resizeBtn = new JButton("Resize 1/4");
		resizeBtn.addActionListener(this);
		
		buttonsPanel.add(horizontalFlipBtn);
		buttonsPanel.add(verticalFlipBtn);
		buttonsPanel.add(resizeBtn);
		
		mainFrame.add(buttonsPanel, BorderLayout.PAGE_END);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		//File -> Open File
		if(e.getSource() == this.openMenuItem)
		{
			fileChooser = new JFileChooser();
			fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
	        fileChooser.setAcceptAllFileFilterUsed(false);
	        FileNameExtensionFilter filter = new FileNameExtensionFilter("BMP Images", "bmp");
	        fileChooser.addChoosableFileFilter(filter);
	        fileChooser.setDialogTitle("Open file");
	        
	        int returnVal = fileChooser.showOpenDialog(null);
	        
	        if (returnVal == JFileChooser.APPROVE_OPTION) 
	        {
	            file = fileChooser.getSelectedFile();
	            try 
	            {
					this.bmp = new Bitmap(file.getAbsolutePath());
					this.initPanelImage(); //Update the panel image with the new BMP file
					JOptionPane.showMessageDialog(mainFrame, "You imported an image with success");

				} 
	            catch (IOException e1) 
	            {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	        } 
	        else 
	        {
	        	JOptionPane.showMessageDialog(mainFrame, "Ooops... something went wrong");
	        }

		}
		
		//Flip horiontal
		if(e.getSource() == this.horizontalFlipBtn)
		{
			if(bmp == null)
			{
				JOptionPane.showMessageDialog(mainFrame, "Please, import an image first.");
			}
			else
			{				
				this.bmp.setData(Bitmap.pixelToByteArray(this.bmp.flipHorizontal()));
				this.refreshPanelImage();
			}
		}
		//Flip Vertical
		if(e.getSource() == this.verticalFlipBtn)
		{
			if(bmp == null)
			{
				JOptionPane.showMessageDialog(mainFrame, "Please, import an image first.");
			}
			else
			{				
				this.bmp.setData(Bitmap.pixelToByteArray(this.bmp.flipVertical()));
				this.refreshPanelImage();
			}
		}
		//Resize 1/4
		if(e.getSource() == this.resizeBtn)
		{
			if(bmp == null)
			{
				JOptionPane.showMessageDialog(mainFrame, "Please, import an image first.");
			}
			else
			{				
				this.bmp.resize();
				this.refreshPanelImage();
			}
		}
		if(e.getSource() == this.saveMenuItem)
		{
			if(bmp == null)
			{
				JOptionPane.showMessageDialog(mainFrame, "Please, import an image first.");
			}
			else
			{				
				try 
				{
					this.bmp.saveToBmp(file.getAbsolutePath(), this.bmp.getPixelArray());
					JOptionPane.showMessageDialog(mainFrame, "Image saved with success");
				} 
				catch (IOException e1) 
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		if(e.getSource() == this.saveAsMenuItem)
		{
			if(bmp == null)
			{
				JOptionPane.showMessageDialog(mainFrame, "Please, import an image first.");
			}
			else
			{
				fileChooser = new JFileChooser();
				fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		        fileChooser.setAcceptAllFileFilterUsed(false);
		        FileNameExtensionFilter bmpFilter = new FileNameExtensionFilter("BMP Images", "bmp");
		        FileNameExtensionFilter rawFilter = new FileNameExtensionFilter("RAW Images", "raw");
		        fileChooser.addChoosableFileFilter(bmpFilter);
		        fileChooser.addChoosableFileFilter(rawFilter);
		        fileChooser.setDialogTitle("Save As");
		        
		        int returnVal = fileChooser.showSaveDialog(null);
		        
		        if (returnVal == JFileChooser.APPROVE_OPTION) 
		        {
		        	File file = fileChooser.getSelectedFile();
		            try
		            {
		            	if(getFileExtension(file).equals("bmp"))
		            	{		            		
		            		this.bmp.saveToBmp(file.getAbsolutePath(), this.bmp.getPixelArray());
		            	}
		            	else if(getFileExtension(file).equals("raw"))
		            	{
		            		this.bmp.saveToRaw(file.getAbsolutePath());
		            	}
					} 
		            catch (IOException e1)
		            {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		        }
			}
		}
	}
	private static String getFileExtension(File file) 
	{
        String fileName = file.getName();
        if(fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
        return fileName.substring(fileName.lastIndexOf(".")+1);
        else return "";
    }
}
