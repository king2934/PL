<?php
date_default_timezone_set('PRC');
/*
**	font-family: 'Roboto Mono Local',monospace;
*/
$dir = dirname(__FILE__);
$logs_error = '/data/local/apache/htdocs/www/webvpn/logs/error.log';
$logs_success = '/data/local/apache/htdocs/www/webvpn/logs/success.log';

function log_w($path,$str)
{
	$log = '';
	if( file_exists($path) ){
		$log = file_get_contents($path);
	}
	file_put_contents($path,$log.date('Y-m-s H:i:s').' '.$str);
}
/**
 * 检测端口是否开放
 * @param $ip
 * @param $port
 * @return string
 */
function checkPort($ip,$port) 
{
    $sock = socket_create(AF_INET, SOCK_STREAM, SOL_TCP);
    socket_set_nonblock($sock);
    socket_connect($sock,$ip, $port);
    socket_set_block($sock);
    $return = @socket_select($r = array($sock), $w = array($sock), $f = array($sock), 3);
    socket_close($sock);
    switch($return)
    {
        case 2:
            echo "$ip:$port 关闭\n";
            break;
        case 1:
            echo "$ip:$port 打开\n";
            break;
        case 0:
            echo "$ip:$port 超时\n";
            break;
    }

}

$cmd_ping = 'ping -c 3 192.168.9.178';

exec($cmd_ping,$out_a,$status_a);
if( $status_a===0){
	log_w($logs_success,"success:开始 $cmd_ping \n");
	$pt=false;
	$array=array();
	foreach($out_a as $key=>$val)
	{
		if( !empty($val) ){
			$vals = explode('icmp_seq=',$val);
			//log_w($logs_success,"vals:ping的item $val \n");
			if( !empty($vals) ){
				//log_w($logs_success,"ping的第几条返回:ping的第几条返回 $val \n");
				if ( count($vals) >=2 ){
					//log_w($logs_success,"icmp_seq:ping的第n条返回 $val \n");
					$str = $vals[1];
					$str = substr($str,0,1);
					if ($str=="1" or $str=="2" or $str=="3"){
						$pt=true;
						array_push($array,$val);
					}
				}
			}
		}
	}
	if($pt){
		log_w($logs_success,"success:与192.168.9.178主机网络通信正常 \n");
/* 		$String = '';
		foreach($array as $value){
			$String .= $value."\n";
			log_w($logs_success,"success: $value \n");
		}
		//log_w($logs_success,"success: $String \n");
 */	}else{
		log_w($logs_error,"error: icmp_seq 显示网络通信异常 $cmd_ping. \n");
		$cmd_ppp = 'php ppp178.php';
		exec($cmd_ppp,$out_b,$status_b);
	}
}else{
	log_w($logs_error,"error: return $status_a ping命令没有执行 $cmd_ping. \n");
}
/* if( $status===0){
	$array = array();
	$pt = false;
	foreach($out as $key=>$val)
	{
		if( !empty($val) ){
			$vals = explode('icmp_seq=',$val);
			if( !empty($vals) ){
				if ( count($vals) >=2 ){
					$str = $vals[1];
					$str = substr($str,0,1);
					if ($str=="1" or $str=="2" or $str=="3"){
						//echo $str."\n";
						$pt=true;
						array_push($array,$val[$key]);
					}
				}
			}
		}
	}
	if($pt){
		$strings = '';
		foreach($array as $k=>$v){
			$strings .= $v."\n";
		}
		log_w($logs_success,$strings);
	}else{
		log_w($logs_error,"error: ping 了 但不通. \n");
	}
}else{
	//echo "Please wait...\n";
	log_w($logs_error,"Error: $cmdping \n");
	$cmdstr = 'php ppp178.php';
	exec($cmdstr,$out,$status);
	if( $status===0){
		log_w($logs_success,"cmd: php ppp178.php. \n");
	}else{
		log_w($logs_error,"error: php ppp178.php. \n");
	}
} */
?>
