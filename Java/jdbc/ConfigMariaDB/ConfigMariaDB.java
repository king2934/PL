import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ConfigMariaDB
{
	public static void main(String[] args)
	{
		UtilDB db = new UtilDB();
		db.setConfig(new Config().getConfig());
		db.connect();
		List<Map> data = db.data("select * from user");
		db.close();
		System.out.println("o"+data.toString() );
	}
}