<?php
function Traversing_Directory($directory)
{
	if( !is_dir($directory) )
	{
		echo "error:".$directory." is not Directory,return false.";
		return false;
	}
	
	$open_dir_directory = opendir($directory);
	if( !$open_dir_directory )
	{
		echo "error:".$directory." is not opendir,return false.";
		return false;
	}
	
	if( $open_dir_directory )
	{
		while( ( $read_dir_directory = readdir($open_dir_directory) ) !== false )
		{
			$temp = $directory.DIRECTORY_SEPARATOR.$read_dir_directory;
			if( is_dir($temp) && $read_dir_directory!='.' && $read_dir_directory != '..'){
				echo '目录：'.$temp.'\n';
				Traversing_Directory($temp);
			}
			
			if( is_file($temp) && $read_dir_directory!='.' && $read_dir_directory != '..')
			{
				echo '文件:'.$temp."\n";
			}
		}
	}
}
Traversing_Directory("software");
?>