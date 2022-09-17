package com.edge.drools;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.StatelessKieSession;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class DroolsApplication {

    public static void main(String[] args) {
        SpringApplication.run(DroolsApplication.class, args);

        KieContainer kc = KieServices.Factory.get().getKieClasspathContainer();
        System.out.println(kc.verify().getMessages().toString());
        execute(kc);
    }

    public static void execute(KieContainer kc) {
        StatelessKieSession ksession = kc.newStatelessKieSession("DecisionTableKS");

        //now create some test data
        Driver driver = new Driver();
        Policy policy = new Policy();

        ksession.execute(Arrays.asList(driver, policy));

        System.out.println("BASE PRICE IS: " + policy.getBasePrice());
        System.out.println("DISCOUNT IS: " + policy.getDiscountPercent());

        policy.getBasePrice();
    }

}
