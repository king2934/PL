<?php

class mssqlApi
{
	private $UID;
	private $PWD;
	private $DB;
	private $ServerName;
	private $CONN;
	
	//class start
	function __construct()
	{
		$this->init();
	}
	
	//class end
	function __destruct()
	{
		//$this->close();
	}
	
	function init()
	{
		$this->UID = 'sa';
		$this->PWD = 'king';
		$this->ServerName = '127.0.0.1';
		$this->DB = 'master';
		$this->connect();
	}
	
	//连接
	function connect()
	{
		$connectionInfo = array( 
			"UID"=>$this->UID,
			"PWD"=>$this->PWD,
			"Database"=>$this->DB
		);
		$this->CONN = sqlsrv_connect( $this->ServerName, $connectionInfo);
		if( $conn === false ) {
			//die( print_r( sqlsrv_errors(), true));
		}
	}
	
	/*
	**	936 简体中文GBK 
	**	950 繁体中文BIG5 
	**	437 美国/加拿大英语 
	**	932 日文 
	**	949 韩文 
	**	866 俄文 
	**	65001 unicode UFT-8
	*/
	public function getnames()
	{
		$sql = "select collationproperty ('Chinese_PRC_Stroke_CI_AI_KS_WS', 'CodePage')";
		$stmt = sqlsrv_query( $this->CONN, $sql );
		$row = sqlsrv_fetch_array( $stmt, SQLSRV_FETCH_NUMERIC);//SQLSRV_FETCH_ASSOC/SQLSRV_FETCH_NUMERIC/SQLSRV_FETCH_BOTH 
		$encode = $row[0];
		sqlsrv_free_stmt($stmt);
		return $encode;
	}
	
	//关闭数据库
	public function close()
	{
		sqlsrv_close($this->CONN);
	}
	
}
?>