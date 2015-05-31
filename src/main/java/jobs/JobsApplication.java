package jobs;

import jobs.controller.TestController;
import jobs.entities.Employer;
import jobs.entities.Region;
import jobs.entities.Sphere;
import jobs.entities.Vacancy;
import jobs.repository.EmployerRepository;
import jobs.repository.RegionRepository;
import jobs.repository.SphereRepositorry;
import jobs.repository.VacancyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JobsApplication {

//    @Autowired
//    VacancyRepository vacancyRepository;
//
//    @Autowired
//    EmployerRepository employerRepository;
//
//    @Autowired
//    SphereRepositorry sphereRepositorry;
//
//    @Autowired
//    RegionRepository regionRepository;

    public static void main(String[] args) {
        SpringApplication.run(JobsApplication.class, args);
    }


//    @Override
//    public void run(String... strings) throws Exception {
//        Region region = regionRepository.findOne(1L);
//        Sphere sphere = sphereRepositorry.findOne(1L);
//        Employer employer = employerRepository.findOne(1L);
//        Vacancy vacancy = new Vacancy();
//        vacancy.setTitle("Test");
//        vacancy.setEmployer(employer);
//        vacancy.setRegion(region);
//        vacancy.setSphere(sphere);
//        vacancy.setDescription("Test");
//        vacancy.setOffer("Test");
//        vacancy.setRequirements("Test");
//
//        vacancyRepository.save(vacancy);
//    }
}
