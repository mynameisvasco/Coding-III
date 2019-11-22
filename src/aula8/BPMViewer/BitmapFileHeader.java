package aula8.BPMViewer;

public class BitmapFileHeader 
{
	private short type; // must be 'BM' to declare a bmp-file
	private int size; // specifies the size of the file in bytes 
	private short reserved1; // must always be set to zero
	private short reserved2; // must always be set to zero
	private int offBits; // specifies the offset from the beginning of the file to the bitmap data
	
	public short getType() 
	{
		return type;
	}

	public int getSize() 
	{
		return size;
	}

	public short getReserved1() 
	{
		return reserved1;
	}

	public short getReserved2() 
	{
		return reserved2;
	}

	public int getOffBits() 
	{
		return offBits;
	}

	public BitmapFileHeader(short type, int size, int offBits)
	{
		this.type = type;
		this.size = size;
		this.reserved1 = 0;
		this.reserved2 = 0;
		this.offBits = offBits;
	}
}
