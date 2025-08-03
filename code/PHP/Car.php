<?php
namespace App;
class Car {
    protected $name;
    protected $year;

    public function __construct($name, $year){
        $this->name = $name;
        $this->year = $year;
    }

    public function __destruct() {
        echo "objek dihancurkan";
    }

    public function startEngine(){
        echo "start engine $this->name";
    }
}