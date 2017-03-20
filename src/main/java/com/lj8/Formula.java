package com.lj8;


interface Formula {
    double calculate(int a);

    default double sqrt(int a){
        return Math.sqrt(a);
    }
}
