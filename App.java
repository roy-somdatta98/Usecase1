package Cts.hackathon;

/**
 * Hello world!
 *
 */
import java.io.*;
import org.json.simple.*;
import java.util.*;
public class App 
{
    public static void main( String[] args )throws IOException
    {
    	BufferedReader br=new BufferedReader(new FileReader("Memory.txt"));
    	String line;
    	int count=0;
    	ArrayList<Integer> bytearray=new ArrayList<Integer>();
    	while((line=br.readLine())!=null) {
    		count++;
    		if(count%2==0) {
    			String data[]=line.split("\\s+");
		
    			bytearray.add(Integer.parseInt(data[2]));
    			
    		}
    		
    	}
    	
    	System.out.println(bytearray);
    	JSONObject bytestore=new JSONObject();
    	JSONObject value=new JSONObject();
    	JSONObject maxMB=new JSONObject();
    	// finaljson= new JSONObject();
    	JSONArray finalarray=new JSONArray();
    	float max=0.0f;
    	float avg=0.0f;
    	System.out.println(bytearray.size());
    	for(int i=0;i<bytearray.size();i++) {
    		String x=(i+1)+"s";
    		
    		
    		float MB=((float)bytearray.get(i)/1024);
    		bytestore.put(x, String.format("%.2f", MB));
    		if(MB>max)
    			max=MB;
    		avg+=MB;
    	}
    	
    	avg=avg/bytearray.size();
    	value.put("AverageMemory(MB)", (String.format("%.2f",avg)));
    	value.put("value",bytestore);
    	value.put("MaxMemory(MB)", (String.format("%.2f",max)));
    	value.put("Usercasename", "HomePage");
    	System.out.println(value);
    	finalarray.add(value);
    	
    	FileWriter file=new FileWriter("Output.json");
    	file.write(finalarray.toJSONString());
    	file.close();
    	br.close();
    	
        
    }
}
