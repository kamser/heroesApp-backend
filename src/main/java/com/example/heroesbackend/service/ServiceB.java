package com.example.heroesbackend.service;

public interface ServiceB {
    public ServiceA getServiceA();
    public void setServiceA(ServiceA serviceA);
    public int multiplyAddition(int a, int b, int multiplicator);

    public int multiply(int a, int b);
}
