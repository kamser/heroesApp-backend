package com.example.heroesbackend.service.serviceImplementation;

import com.example.heroesbackend.service.ServiceA;
import com.example.heroesbackend.service.ServiceB;

public class ServiceBImpl implements ServiceB {

    private ServiceA serviceA;  // Esto es una dependencia
    @Override
    public ServiceA getServiceA() {
        return serviceA;
    }

    @Override
    public void setServiceA(ServiceA serviceA) {
        this.serviceA = serviceA;
    }

    @Override
    public int multiplyAddition(int a, int b, int multiplicator) {
        return serviceA.addition(a, b) * multiplicator;
    }

    @Override
    public int multiply(int a, int b) {
        return a*b;
    }
}
