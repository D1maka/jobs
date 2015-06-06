package jobs.controller;

import jobs.repository.EmployerRepository;
import jobs.repository.VacancyRepository;
import jobs.service.UserService;
import jobs.service.forms.EmployeeRegistrationFrom;
import jobs.service.forms.EmployerRegistrationForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by dmytro_veres on 31.05.2015.
 */
@Controller
public class TestController {
    @Autowired
    private VacancyRepository vacancyRepository;

    @Autowired
    private EmployerRepository employerRepository;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getIndex(Model model) {
        model.addAttribute("employeeForm", new EmployeeRegistrationFrom());
        model.addAttribute("employerForm", new EmployerRegistrationForm());
        return "index";
    }

    @RequestMapping(value = "/vacancies", method = RequestMethod.GET)
    public String getVacancies(Model model) {
        model.addAttribute("vacancies", vacancyRepository.findAll());
        return "vacancies";
    }

    @RequestMapping(value = "/vacancy/{vacancyId}", method = RequestMethod.GET)
    public String getVacancy(@PathVariable Long vacancyId, Model model) {
        model.addAttribute("vacancy", vacancyRepository.findOne(vacancyId));
        return "vacancy";
    }

    @RequestMapping(value = "/employer/{employerId}", method = RequestMethod.GET)
    public String getEmployer(@PathVariable Long employerId, Model model) {
        model.addAttribute("employer", employerRepository.findOne(employerId));
        return "employer";
    }

    @RequestMapping(value = "/register-employee", method = RequestMethod.POST)
    public String registerEmployee(@ModelAttribute EmployeeRegistrationFrom employeeRegistrationFrom) {
        userService.create(employeeRegistrationFrom);
        return "vacancies";
    }

    @RequestMapping(value = "/register-employer", method = RequestMethod.POST)
    public String registerEmployer(@ModelAttribute EmployerRegistrationForm employerRegistrationForm) {
        userService.create(employerRegistrationForm);
        return "employer";
    }
//
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(@RequestParam String error) {

        return new ModelAndView("login", "error", error);
    }
}
