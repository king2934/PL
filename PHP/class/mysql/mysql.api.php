<?php
date_default_timezone_set('PRC');
//date_default_timezone_set("Asia/Shanghai");
/*
**	调用 
**	$my = new MYSQLAPI();
**	$my->ExecSql($sql);
**	$my->close();
*/
class MYSQLAPI{
	private $HOSTNAME = "localhost";
	private $USERNAME = "username";
	private $PASSWORD = "password";
	private $DATABASE = "database";
	
	private $CONNECTION = NULL;
	private $INSERTID = NULL;
	
	//初始化连接
	function __construct()
	{
		$this->CONNECTION = mysqli_connect($this->HOSTNAME,$this->USERNAME,$this->PASSWORD,$this->DATABASE);
		if(!$this->CONNECTION){
			die("连接失败".mysqli_connect_error()); 
		}
	}
	
	//本类结束时执行
	function __destruct()
	{
		//如果不在其他类文件中使用本类 可以取消下列注释
		//$this->close();
	}
	
	//执行SQL语句
	public function ExecSql($sql)
	{
		$query = mysqli_query($this->CONNECTION,$sql);
		return $query;
	}
	
	//执行SQL语句 insert 返回ID
	public function ExecSqlInsert($sql)
	{
		$query = mysqli_query($this->CONNECTION,$sql);
		$this->INSERTID =  mysqli_insert_id($this->CONNECTION);
		return $query;
	}
	
	//取得刚刚执行insert 返回的ID
	public function get_mysqli_insert_id()
	{
		return $this->INSERTID;
	}
	
	//获取SQL中的一条数据 索引 0
	public function DataRow($sql)
	{
		$result = mysqli_query($this->CONNECTION,$sql);
		$row = mysqli_fetch_row($result);
		return $row;
	}
	
	//获取SQL中的所有条数据 索引 0
	public function DataRows($sql)
	{
		$result = mysqli_query($this->CONNECTION,$sql);
		$datas = array();
		while($row = mysqli_fetch_row($result)){
			array_push($datas,$row);
		}	
		return $datas;
	}
	
	//获取SQL中的一条数据 索引 $key
	public function Data($sql)
	{
		$result = mysqli_query($this->CONNECTION,$sql);
		$data = mysqli_fetch_assoc($result);
		return $data;
	}
	
	//获取SQL中的所有条数据 索引 $key
	public function Datas($sql)
	{
		$result = mysqli_query($this->CONNECTION,$sql);
		$datas = array();
		while($row = mysqli_fetch_assoc($result)){
			array_push($datas,$row);
		}		
		return $datas;
	}
	
	//关闭本类的mysql连接
	public function close()
	{
		mysqli_close($this->CONNECTION);
	}
}
?>