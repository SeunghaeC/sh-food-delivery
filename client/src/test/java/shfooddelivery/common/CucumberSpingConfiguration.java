package shfooddelivery.common;


import shfooddelivery.ClientApplication;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = { ClientApplication.class })
public class CucumberSpingConfiguration {
    
}
