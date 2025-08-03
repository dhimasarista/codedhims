<?php
$data = [
    [
        "name" => "dhimasarista",
        "age" => 22,
    ]
];

array_push($data, [
    "name" => "anto",
    "age" => 30
]);

$object = json_decode(json_encode($data));

foreach ($object as $key => $value) {
    echo $value->name . " - " . $value->age . "\n";
}