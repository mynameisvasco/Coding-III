package aula8.BPMViewer;

public class BitmapInfoHeader 
{
	private int size;
    private int width;
    private int height;
    private short planes;
    private short bitCount;
    private int compression;
    private int sizeImage;
    private int xPelsPerMeter;
    private int yPelsPerMeter;
    private int clrUsed;
    private int clrImportant;
	
    public BitmapInfoHeader(int size, int width, int height, short planes, short bitCount, int compression,
			int sizeImage, int xPelsPerMeter, int yPelsPerMeter, int clrUsed, int clrImportant) 
    {
		super();
		this.size = size;
		this.width = width;
		this.height = height;
		this.planes = planes;
		this.bitCount = bitCount;
		this.compression = compression;
		this.sizeImage = sizeImage;
		this.xPelsPerMeter = xPelsPerMeter;
		this.yPelsPerMeter = yPelsPerMeter;
		this.clrUsed = clrUsed;
		this.clrImportant = clrImportant;
	}

	public int getSize() 
	{
		return size;
	}

	public int getWidth() 
	{
		return width;
	}

	public int getHeight() 
	{
		return height;
	}

	public short getPlanes() 
	{
		return planes;
	}

	public short getBitCount() 
	{
		return bitCount;
	}

	public int getCompression() 
	{
		return compression;
	}

	public void setWidth(int width) 
	{
		this.width = width;
	}

	public void setHeight(int height) 
	{
		this.height = height;
	}

	public int getSizeImage() 
	{
		return sizeImage;
	}

	public int getxPelsPerMeter() 
	{
		return xPelsPerMeter;
	}

	public int getyPelsPerMeter() 
	{
		return yPelsPerMeter;
	}

	public int getClrUsed() 
	{
		return clrUsed;
	}

	public int getClrImportant() 
	{
		return clrImportant;
	}
    
    
}
