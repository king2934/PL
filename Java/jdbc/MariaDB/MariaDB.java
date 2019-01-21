import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MariaDB
{
	public static void main(String[] args)
	{
		Map<String,String> config = new HashMap<String,String>();
		
		config.put("HostName","localhost");
		config.put("HostPort","3308");
		config.put("UserName","root");
		config.put("PassWord","123456");
		config.put("DataBase","mysql");
		
		UtilDB db = new UtilDB(config);
		db.setConfig(config);
		db.connect();
		List<Map> data = db.data("select user,host,password from user");
		System.out.println(data.toString());
		db.close();
	}
}