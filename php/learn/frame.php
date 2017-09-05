<?php
$data = file_get_contents(__DIR__ . "/frame.json");
//$data = str_ireplace(",", "\\,", $data);

$data = json_decode($data);

//var_dump($data);

echo "year,approach,framework,author,pubtitle,link,description\n";

foreach($data as $row){
    $row = (array)$row;

    echo $row["date"] . ",";
    echo $row["approach"] . ",";
    echo $row["framework"] . ",";
    echo str_ireplace(",", ".", $row["author"]), ",";
    echo str_ireplace(",", ".", $row["pubtitle"]), ",";
    //echo $row["pubtitle"] . ",";
    echo str_ireplace(",", ".", $row["url"]), ",";
    echo str_ireplace(",", ".", $row["description"]), "";
    //echo $row["url"] . ",";
    //echo $row["author"] . ",";
    //echo $row["description"] . "";
    echo "\n";    
}
