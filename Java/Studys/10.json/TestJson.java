import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

public class TestJson
{
	public static void main(String[] args)
	{
		TestJson tj = new TestJson();
		tj.show();
		System.out.println("json com.google.gson");
	}
	
	public TestJson()
	{
		
	}
	
	public void show()
	{
		Gson gson = new Gson();
		List list = getList();
		String jsonStr = gson.toJson(list);
		String maps = gson.toJson(getMap());
		
		System.out.println("json list:"+jsonStr);
		System.out.println("json map:"+maps);
	}
	
	public Map<String,String> getMap()
	{
		Map<String,String> map = new HashMap<String,String>();
		map.put("user","user1");
		map.put("pass","pass1");
		return map;
	}
	
	public List getList()
	{
		List<Map<String,String>> list = new ArrayList<Map<String,String>>();
		list.add(getMap());
		list.add(getMap());
		list.add(getMap());
		return list;
	}
}