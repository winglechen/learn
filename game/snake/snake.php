<?php
$n = 8;
$b = pow($n,2);



function turn($dir)
{
	switch ($dir) {
		case 'down':
			return 'left';
		case 'up':
			return 'right';	
		case 'right':
			return 'down';
		case 'left':
			return 'up';	
	}
}

$data		= [];
$row		= 1;
$col		= $n;

$round		= $n;
$dir		= 'down';
for($i=1; $i<=$b; $i++){
	if(!isset($data[$row][$col])){
		$data[$row][$col] = $i;
	}	
	if($dir === 'down'){
		if($row === $round){
			$dir = turn($dir);
			$col--;
			continue;	
		}
		$row++;		
	}elseif($dir === 'left'){
		if($col === $n - $round + 1){
			$dir = turn($dir);
			$row--;
			continue;	
		}
		$col--;
	}elseif($dir === 'up'){
		if($row === $n - $round + 1 ){
			$dir = turn($dir);
			$col++;
			continue;	
		}
		$row--;
	}elseif($dir === 'right'){
		if($col === $round - 1){//round end
			$dir = turn($dir);
			$row++;
			$round--;
			continue;	
		}
		$col++;
	}

}

foreach($data as $row){
	ksort($row);
	echo join("\t",$row)."\n";
}

