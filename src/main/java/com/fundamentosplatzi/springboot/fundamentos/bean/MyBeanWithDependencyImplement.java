package com.fundamentosplatzi.springboot.fundamentos.bean;

public class MyBeanWithDependencyImplement implements MyBeanWithDependency{

    private MyOperation myOperation;

    public MyBeanWithDependencyImplement(MyOperation myOperation){
        this.myOperation = myOperation;
    }

    @Override
    public void printWithDependency(int number) {
        System.out.println( myOperation.sum(number));
        System.out.println("Hoal desde la implementacion de un bean con dependencia");
    }
}
