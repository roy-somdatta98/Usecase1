package com.cts.h2;


import java.io.*;
import org.json.simple.*;
import java.text.DecimalFormat;


public class Battery {

	public static void main(String[] args)throws Exception{
		
		String data;
		
		FileReader fr=new FileReader("D:\\Battery.txt");
		BufferedReader br=new BufferedReader(fr);
		
		JSONObject values=new JSONObject();
		//JSONArray batteryarray=new JSONArray();
		DecimalFormat df=new DecimalFormat("0.000");
		
		
		while((data=br.readLine())!=null) {
			if(data.contains("Foreground activities")) {
				String[] val=data.split("\\s+");
				String val2=val[3]+" "+val[4]+" "+val[5]+" "+val[6]+" "+val[7]+" "+val[8];
				//System.out.print(val2);
				values.put("Foreground activities",val2);
			}
			if(data.contains("Uid u0a202")) {
				String[] val3=data.split("\\s+");
				//System.out.println(val3[3]);
				double drain_val=Double.parseDouble(val3[3]);
				double drain_percentage= drain_val/1000;
				String percentage=df.format(drain_percentage);
				
				values.put("Battery_percentage",percentage);
				values.put("Battery_drain",drain_val);
				
			}
			
		}
		//batteryarray.add(values);
		System.out.println(values);
		FileWriter fw=new FileWriter("UseCase2Output.json");
		fw.write(values.toJSONString());
		fw.close();
		br.close();
		
		

	}

}
