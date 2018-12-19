<?php
/*
** $cvn = new CheckVerifyNumber();
** $cvn->verify_mobile($number);
** $cvn->verify_email($number);
** $cvn->verify_taxid($number);
** return true/false;
*/
class CheckVerifyNumber
{
	//检验手机号码是否符合格式
	public function verify_mobile($mobile)
	{
		if( trim($mobile) ){
			if( strlen($mobile) == 11){
				if( preg_match("/^1[34578]{1}\d{9}$/",$mobile) ){
					return true;
				}else{
					return false;
				}
			}else{
				return false;
			}
		}else{
			return false;
		}
	}
	//检验邮箱是否符合格式
	public function verify_email($email)
	{
		if( trim($email) ){
			if( strlen($email) >= 6){
				$pattern = '/^[a-z0-9]+([._-][a-z0-9]+)*@([0-9a-z]+\.[a-z]{2,14}(\.[a-z]{2})?)$/i';
				if(preg_match($pattern,$email)){
					return true;
				}else{
					return false;
				}
			}else{
				return false;
			}
		}else{
			return false;
		}
	}
	
	//检验身份证号码是否符合格式
	public function verify_taxid($taxid)
	{
		if( strlen($taxid)==18 ){
			if( $this->check_PAC($taxid) ){
				if( $this->check_year_month_day($taxid) ){
					$vernum = $this->verify_number($taxid);
					$lastnum = strtoupper(substr($taxid,17,1));
					if( $vernum == $lastnum){
						return true;
					}else{
						return false;
					}					
				}else{
					return false;
				}				
			}else{
				return false;
			}
		}else{
			return false;
		}
	}
	
	//省级地址码 PAC = ProvincialAddressCode
	function check_PAC($taxid)
	{
		$return=false;
		$codes = array(
			"110000",//北京市
			"120000",//天津市
			"130000",//河北省
			"140000",//山西省
			"150000",//内蒙古自治区
			"210000",//辽宁省
			"220000",//吉林省
			"230000",//黑龙江省
			"310000",//上海市
			"320000",//江苏省
			"330000",//浙江省
			"340000",//安徽省
			"350000",//福建省
			"360000",//江西省
			"370000",//山东省
			"410000",//河南省
			"420000",//湖北省
			"430000",//湖南省
			"440000",//广东省
			"450000",//广西壮族自治区
			"460000",//海南省
			"500000",//重庆市
			"510000",//四川省
			"520000",//贵州省
			"530000",//云南省
			"540000",//西藏自治区
			"610000",//陕西省
			"620000",//甘肃省
			"630000",//青海省
			"640000",//宁夏回族自治区
			"650000",//新疆维吾尔自治区
			"710000",//台湾省(886)			
			"810000",//香港(852)
			"820000"//澳门(853)
		);
		$code = substr($taxid,0,2)."0000";
		foreach($codes as $val)
		{
			if($code==$val)
			{
				$return=true;
				break;
			}
		}
		return $return;
	}
	
	//年月分和天数
	function check_year_month_day($taxid)
	{
		$year = (int)substr($taxid,6,4);
		if( $year>1900 ){
			$month = (int)substr($taxid,10,2);
			if( $month<1 or $month>12 ){
				return false;
			}else{
				$day = (int)substr($taxid,12,2);
				if( $day<1 or $day>31){
					return false;
				}else{
					$dayCount = date("t",strtotime($year."-".$month));
					//$dayCount = cal_days_in_month(CAL_GREGORIAN,$month,$year);
					if($day>$dayCount){
						return false;
					}else{
						return true;
					}
				}
			}
		}else{
			return false;
		}
	}

	//身份证校验码
	function verify_number($taxid)
	{
		$map=array(1, 0, X, 9, 8, 7, 6, 5, 4, 3, 2);
		$sum = 0;
		for($i = 17; $i > 0; $i--){
			$s = pow(2, $i) % 11;//次方
			$sum += $s * $taxid[17-$i];
		}
		return $map[$sum % 11];
	}
}
?>