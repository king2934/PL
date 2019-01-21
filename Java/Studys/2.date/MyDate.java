import java.util.TimeZone;
import java.util.Date;
import java.text.SimpleDateFormat;

public class MyDate
{
	public static void main(String args[])
	{
		MyDate md = new MyDate();
		String d = md.strDate();
		String df = md.strDateFormat();
		System.out.println(" main date : "+d);
		System.out.println(" main date : "+df);
	}
	
	//
	public String strDate()
	{
		Date d = new Date();
		String dstr = d.toString();
		System.out.println(dstr);
		return dstr;
	}
	
	//
	public String strDateFormat()
	{
		//TimeZone.setDefault(TimeZone.getTimeZone("UTC"));//PRC
		SimpleDateFormat sdf = new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss");
		Date d = new Date();
		String dstr = sdf.format(d);
		System.out.println(dstr);
		return dstr;
	}
}