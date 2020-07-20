import java.io.*;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;

public class ReadFileJson
{
	public static void main(String[] args)
	{
		ReadFileJson rfj = new ReadFileJson();
		System.out.println("read file for config.json");
	}
	
	public ReadFileJson()
	{
		File file = new File("config.json");
		if( file.exists() ){
			System.out.println("config.json YES");
			try
			{
				InputStream  is = new FileInputStream(file);
				InputStreamReader isr = new InputStreamReader(is);
				JsonReader jsonReader = new JsonReader(isr);
				BufferedReader br = new BufferedReader(isr);
				String result = "";
				String line="";
				while((line=br.readLine()) != null)
				{
					line = line.trim();
					line = line.replaceAll("\n","");
					line = line.replaceAll("\r","");
					result += line;
				}
				isr.close();
				System.out.println("result:"+result);
			}
			catch(IOException e)
			{
				
			}
		}else{
			System.out.println("config.json is not fount!");
		}
	}
	
	
}