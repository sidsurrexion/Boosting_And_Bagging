import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import weka.core.Instances;
import weka.core.converters.ArffSaver;
import weka.core.converters.CSVLoader;

import com.csvreader.CsvWriter;


public class FileReader {
	public static void main (String args[]) throws IOException {		
		String filedirectory = new File("").getAbsolutePath();
		String csv = ".csv";
		String arff = ".arff";
		String filename = null;
		String csv_file = null;
		String arff_file = null;
		String line = null;		
		StringTokenizer stringtokenizer = null;
		String set = null;
		String extension = null;
		String text = "txt";
		
		BufferedReader reader = null;
	    FileInputStream fis = null;
	    
	    int edge = 0;
	    
	    Boolean bool_file = false;
	    
	    File file = null;
		file = new File(filedirectory);
	    String[] paths = file.list();
	    
	    
	    for (String path: paths){
	    	
	    	extension = path.substring(path.lastIndexOf(".") + 1, path.length());
			
			if (extension.equals(text)){
				
				filename  = path.substring(0, path.lastIndexOf("."));
				
				csv_file = filename + csv;
				File csvfile = new File(filedirectory + "//" + csv_file);
				
				CsvWriter csvwriter = new CsvWriter(new FileWriter(csvfile,true),',');
				
				if (!csvfile.exists()){
					csvfile.createNewFile();
				}
			
				fis = new FileInputStream(filedirectory + "//" + path);
				
				reader = new BufferedReader(new InputStreamReader(fis));
				
				while ((line = reader.readLine()) != null){
					
					stringtokenizer = new StringTokenizer(line, ",");
					edge = stringtokenizer.countTokens();
					
					if ( bool_file == false){
    					for ( int i = 0; i < edge - 1; i++){						
    						csvwriter.write("a" + String.valueOf(i));    						
    					}
    					csvwriter.write("class");
    					csvwriter.endRecord();
    					
    					bool_file = true;
    				}
					
					while(stringtokenizer.hasMoreTokens()){
    					
    					set = stringtokenizer.nextToken();
    					csvwriter.write(set);
    					
    				}
					
					csvwriter.endRecord();
				}
				
				bool_file = false;
				
				csvwriter.flush();
	       		csvwriter.close();
	       		
	       		arff_file = filedirectory + "//" + filename + arff;
	       		CSVLoader loader = new CSVLoader();
	       		loader.setSource(csvfile);
	       		Instances data = loader.getDataSet();
	       		   
	       		ArffSaver saver = new ArffSaver();
	       		saver.setInstances(data);
	       		saver.setFile(new File(arff_file));
	       		saver.writeBatch();
	       		   
	       		csv_file = null;
	       		arff_file = null;
			}
	    	
	    }
	}
}
