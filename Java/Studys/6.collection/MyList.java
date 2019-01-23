import java.util.List;
import java.util.ArrayList;

public class MyList
{
	public static void main(String[] args)
	{
		MyList ml = new MyList();
		System.out.println(ml.mlist().toString());
	}
	
	public List mlist()
	{
		List<String> list = new ArrayList<>();
		list.add("第一个值");
		list.add("第二个值");
		list.add("第三个值");
		return list;
	}
}