import java.util.Map;
import java.util.HashMap;

public class MyMap
{
	public static void main(String[] args)
	{
		MyMap mm = new MyMap();
		mm.getMap();
	}
	
	public void getMap()
	{
		Map<String, String> map = new HashMap<String, String>();
		map.put("1", "value1");
		map.put("2", "value2");
		map.put("key", "value3");
		
		System.out.println(map.toString());
	}
}