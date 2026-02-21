package com.glo.TransportLogisticDomainCapstoneProject;

import com.glo.TransportLogisticDomainCapstoneProject.controller.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.glo.TransportLogisticDomainCapstoneProject")
public class TransportLogisticDomainCapstoneProjectApplication implements CommandLineRunner {
    private Controller controller;

    @Autowired
    public void setController(Controller controller) {
        this.controller = controller;
    }

	public static void main(String[] args) {
		SpringApplication.run(TransportLogisticDomainCapstoneProjectApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
        controller.run();
    }
}
