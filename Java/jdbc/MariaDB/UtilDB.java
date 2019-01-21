import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class UtilDB
{
	//驱动名
	private static final String JDBC_DRIVER = "org.mariadb.jdbc.Driver";
	
	private Connection conn;
	
	private String DB_URL;
	
	private String _HostName;
	private String _HostPort;
	private String _UserName;
	private String _PassWord;
	private String _DataBase;

	
	// 入口
	public static void main(String[] args)
	{
		System.out.println("this class UtilDB.");
	}
	
	//构造函数
	public UtilDB()
	{
		super();
		this.conn = null;
		this._HostName = "localhost";
		this._HostPort = "3306";
		this._UserName = null;
		this._PassWord = null;
		this._DataBase = null;
		this.DB_URL = "jdbc:mariadb://" + this._HostName + ":" + this._HostPort + "/" + this._DataBase;
	}
	
	//构造函数
	public UtilDB(Map<String,String> config)
	{
		this.setConfig(config);
	}
		
	//配置数据连接config 
	public void setConfig(Map<String,String> map)
	{
		Map<String,String> config = new HashMap<String,String>();
		
		//处理成不区分大小写
		for(String key : map.keySet() )
		{
			config.put( key.toLowerCase(),map.get(key).toString() );
		}
		this._HostName = config.get("hostname");
		this._HostPort = config.get("hostport");
		this._UserName = config.get("username");
		this._PassWord = config.get("password");
		this._DataBase = config.get("database");
		
		this.DB_URL = "jdbc:mariadb://" + this._HostName + ":" + this._HostPort + "/" + this._DataBase;
	}
	
	// 连接数据库 MariaDB
	public void connect()
	{
		try
		{
			// 注册 JDBC 驱动
			Class.forName(this.JDBC_DRIVER);
			this.conn = DriverManager.getConnection(this.DB_URL, this._UserName, this._PassWord);
			System.out.println("连接成功");
		}
		catch (ClassNotFoundException e)
		{
			// 注册 JDBC 驱动 错误提示
			//e.printStackTrace();
			System.out.println("找不到JDBC驱动");
		}
		catch (SQLException e)
		{
			//e.printStackTrace();
			System.out.println("尝试连接数据库没有成功。");
		}
	}
	
	//查询数据
	public List<Map> data(String sql)
	{
		List<Map> rows = new ArrayList<Map>();
		try
		{
			Statement stmt = this.conn.createStatement();
			ResultSet result =  stmt.executeQuery(sql);
			
			ResultSetMetaData rsm = result.getMetaData();
			
			while(result.next())
			{
				Map<String,Object> row = new HashMap<String,Object>();
				for(int i = 1; i <= rsm.getColumnCount(); i++ )
				{
					row.put( rsm.getColumnName(i).toLowerCase(),result.getObject(i) );
				}
				rows.add(row);
			}
			stmt.close();
			result.close();
			//System.out.println("Statement 释放完成.");
			//System.out.println("ResultSet 释放完成.");
		}
		catch (SQLException e)
		{
			//e.printStackTrace();
			System.out.println("Statement 创建时发生了错误");
		}
		return rows;
	}
	
	// 关闭数据库 MariaDB
	public void close()
	{
		try
		{
			this.conn.close();
			System.out.println("数据库已关闭连接。");
		} 
		catch (SQLException e)
		{
			//e.printStackTrace();
			System.out.println("错误提示:数据库连接无法关闭.");
        }
	}
}