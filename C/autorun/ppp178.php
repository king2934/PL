<?php
date_default_timezone_set('PRC');
/*
**	font-family: 'Roboto Mono Local',monospace;
*/
function log_w($path,$str)
{
	$log = '';
	if( file_exists($path) ){
		$log = file_get_contents($path);
	}
	file_put_contents($path,$log.date('Y-m-s H:i:s').' '.$str);
}

$logs_error = '/data/local/apache/htdocs/www/webvpn/logs/error.log';
$logs_success = '/data/local/apache/htdocs/www/webvpn/logs/success.log';

$cmd_ipaddr = 'ip addr |grep 192.168.9.178';

exec($cmd_ipaddr,$out_a,$status_a);
if( $status_a===0){
	$strings = explode('ppp',$out_a[0]);
	$pppname = 'ppp'.$strings[1];
	$pidpath = '/var/run/'.$pppname.'.pid';
	
	$cmd_cat_pid = 'cat '.$pidpath;
	exec($cmd_cat_pid,$out_b,$status_b);
	if( $status_b===0){
		$pid = $out_b[0];
		log_w($logs_success,"PID:".$pid."\n");
		
		$cmd_kill_pid = 'kill -HUP '.$pid;
		exec($cmd_kill_pid,$out_c,$status_c);
		if( $status_c===0){
			log_w($logs_success,$cmd_kill_pid."\n");
		}else{
			log_w($logs_error,"error: return:$status_c 杀进程时出错 $cmd_kill_pid \n");
		}
	}else{
		log_w($logs_error,"error: return:$status_b 查看PID时出错 $cmd_cat_pid \n");
	}
}else{
	log_w($logs_error,"error: return:$status_a 查看IP时出错 $cmd_ipaddr \n");
}

/* exec($cmd,$out_a,$status);
if( $status===0){
	$strings = $out[0];
	$strings = explode('ppp',$strings);
	$ppp = 'ppp'.$strings[1];
	
	$fpath = '/var/run/';
	$fname = $fpath.$ppp.'.pid';
	$pid = file_get_contents($fname);
	//echo $fname."\n";
	//echo $pid."\n";
	if( empty($pid) ){
		log_w($logs_error,"没有取到pid \n");
	}else{
		log_w($logs_success,"get pid. 取到pid \n");
		$cmdkill = 'kill -HUP '.$pid;
		exec($cmdkill,$out_b,$status_b);
		if( $status_b===0 ){
			$log_s = '';
			if(file_exists($logs_success)){
				$log_s = file_get_contents($logs_success);
			}
			
			$cmdstr = str_replace("\n",' ',$cmdkill);
			log_w($logs_success,$cmdstr."\n");
		}else{
			log_w($logs_error,"error: $cmdkill \n");
		}
	}
}else{
	log_w($logs_error,"error:ip addr |grep 192.168.9.178 \n");
} */
?>