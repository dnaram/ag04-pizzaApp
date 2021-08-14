package com.agency04.sbss.pizza;

import com.agency04.sbss.pizza.service.PizzeriaService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");

        // prototype scope demo

        PizzeriaService tinel1 = context.getBean("pizzeriaTinel", PizzeriaService.class);
        PizzeriaService tinel2 = context.getBean("pizzeriaTinel", PizzeriaService.class);

        boolean sameRefs = (tinel1 == tinel2);

        System.out.println("Pointing to the same object: " + sameRefs);

        System.out.println("Memory location for tinel1: " + tinel1);
        System.out.println("Memory location for tinel2: " + tinel2);

        // singleton scope demo

        PizzeriaService alfa1 = context.getBean("pizzeriaAlfa", PizzeriaService.class);
        PizzeriaService alfa2 = context.getBean("pizzeriaAlfa", PizzeriaService.class);

        sameRefs = (alfa1 == alfa2);

        System.out.println("Pointing to the same object: " + sameRefs);

        System.out.println("Memory location for alfa1: " + alfa1);
        System.out.println("Memory location for alfa2: " + alfa2);

    }
}
