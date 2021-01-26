package dev.jlarsen.demo;

import dev.jlarsen.demo.models.Employee;
import dev.jlarsen.demo.models.Location;
import dev.jlarsen.demo.repository.EmployeeMyBatisRepository;
import dev.jlarsen.demo.repository.LocationMyBatisRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class MyBatisDemoApplication {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public static void main(String[] args) {
        SpringApplication.run(MyBatisDemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(EmployeeMyBatisRepository employeeRepository, LocationMyBatisRepository locationRepository) {
        return (args) -> {

            Location la = new Location("Los Angeles", "United States");
            Location ny = new Location("New York", "United States");
            Location paris = new Location("Paris", "France");
            Location vancouver = new Location("Vancouver", "Canada");

//			locationRepository.insertLocation(ny);
//			locationRepository.insertLocation(paris);
//			locationRepository.insertLocation(vancouver);
            locationRepository.insertLocation(la);

//          logger.info("Inserting -> {}", employeeRepository.insert(new Employee("Johnny", "Appleseed", "johnny@gmail.com")));
//			logger.info("Inserting -> {}", employeeRepository.insert(new Employee("Parker", "Pearson", "pp@gmail.com")));
//			logger.info("Inserting -> {}", employeeRepository.insert(new Employee("Bob", "Smith", "bob@gmail.com")));

            Employee testEmployee = employeeRepository.findById(10015);
            logger.info("Employee id 10015: " + testEmployee.getFirstName() + " " + testEmployee.getLastName());

            //logger.info("Update 10003 -> {}", employeeRepository.update(new Employee(10011, "Update", "User", "update@gmail.com")));

            //employeeRepository.deleteById(10013);

            locationRepository.delete(40L);

            la.setCity("Melbourne");
            la.setCountry("Australia");
            locationRepository.update(la);

            Location testLocation = locationRepository.selectById(3L);
            logger.info("Location 3: " + testLocation.getCity() + ", " + testLocation.getCountry());
            testLocation.setCity("Cancun");
            testLocation.setCountry("Mexico");
            locationRepository.update(testLocation);

            List<Location> testLocationList = locationRepository.findAll();
            logger.info("All locations ->");
            for (Location location : testLocationList) {
                logger.info(location.getId() + ": " + location.getCity() + ", " + location.getCountry());
            }

            List<Employee> testEmpList = employeeRepository.findAll();
            logger.info("All employees ->");
            for (Employee employee : testEmpList) {
                logger.info(employee.getId() + ": " + employee.getFirstName() + " " + employee.getLastName() +
                        ", " + employee.getEmail());
            }
        };
    }
}
