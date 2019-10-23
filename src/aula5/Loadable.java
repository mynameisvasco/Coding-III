package aula5;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public interface Loadable 
{	

	void saveFile(Person[] p, String f) throws IOException;
	
	Person[] loadFile(File f) throws FileNotFoundException;
	
}
