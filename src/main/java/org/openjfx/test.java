package org.openjfx;

import org.domain.Operator;
import org.services.ServiceProvider;

import java.util.List;

public class test {
    public static void main(String[] args){
        ServiceProvider serviceProvider = new ServiceProvider();
        List<Operator> operators = serviceProvider.getOperatorDao().getAll();
        for (Operator operator : operators){
            System.out.println(operator.getName());
        }
        System.out.println(serviceProvider.getOperatorDao().findById(1));
    }

}
