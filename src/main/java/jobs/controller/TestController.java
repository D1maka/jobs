package jobs.controller;

import jobs.entities.*;
import jobs.repository.*;
import jobs.security.CurrentUser;
import jobs.service.UserService;
import jobs.service.forms.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    @Autowired
    private ResumeRepository resumeRepository;

    @Autowired
    private RegionRepository regionRepository;

    @Autowired
    private SphereRepositorry sphereRepositorry;

    @Autowired
    private EducationRepository educationRepository;

    @Autowired
    private WorkExperienceRepository workExperienceRepository;

    @Autowired
    private ResumeHistoryRepository resumeHistoryRepository;

    @Autowired
    private VacancyHistoryRepository vacancyHistoryRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getIndex(Model model) {
        model.addAttribute("employeeForm", new EmployeeRegistrationFrom());
        model.addAttribute("employerForm", new EmployerRegistrationForm());
        return "index";
    }

    @RequestMapping(value = "/vacancies", method = RequestMethod.GET)
    public String getVacancies(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) auth.getPrincipal();
        User user = userService.getUserByEmail(userDetails.getUsername());
        System.out.println(user.toString());
        model.addAttribute("currentUser", user);
        model.addAttribute("vacancies", vacancyRepository.findAll());
        return "vacancies";
    }

    @RequestMapping(value = "/vacancies/{employerId}", method = RequestMethod.GET)
    public String getVacanciesByEmployer(@PathVariable Long employerId, Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) auth.getPrincipal();
        User user = userService.getUserByEmail(userDetails.getUsername());
        Employer employer = employerRepository.findOne(employerId);
        model.addAttribute("currentUser", user);
        model.addAttribute("vacancies", vacancyRepository.findAllByEmployer(employer));
        return "vacancies";
    }

    @RequestMapping(value = "/vacancy/{vacancyId}", method = RequestMethod.GET)
    public String getVacancy(@PathVariable Long vacancyId, Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) auth.getPrincipal();
        User user = userService.getUserByEmail(userDetails.getUsername());
        if (user.isEmployee()) {
            model.addAttribute("submitResumeForm", new SubmitResumeForm());
            model.addAttribute("resumes", resumeRepository.findAllByUser(user));
        }
        model.addAttribute("currentUser", user);
        model.addAttribute("vacancy", vacancyRepository.findOne(vacancyId));
        return "vacancy";
    }

    @RequestMapping(value = "/resume/{resumeId}", method = RequestMethod.GET)
    public String getResume(@PathVariable Long resumeId, Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) auth.getPrincipal();
        User user = userService.getUserByEmail(userDetails.getUsername());
        Resume resume = resumeRepository.findOne(resumeId);

        model.addAttribute("currentUser", user);
        model.addAttribute("resume", resume);
        return "resume";
    }

    @RequestMapping(value = "/vacancy/{vacancyId}", method = RequestMethod.POST)
    public String addResumeToVacancy(@PathVariable Long vacancyId, @ModelAttribute SubmitResumeForm submitResumeForm, Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) auth.getPrincipal();
        User user = userService.getUserByEmail(userDetails.getUsername());

        VacancyHistory vacancyHistory = new VacancyHistory();
        Vacancy vacancy = vacancyRepository.findOne(vacancyId);
        vacancyHistory.setResume(resumeRepository.findOne(submitResumeForm.getResumeId()));
        vacancyHistory.setVacancy(vacancy);
        vacancyHistory.setDate(new Date());
        vacancyHistoryRepository.save(vacancyHistory);

        model.addAttribute("currentUser", user);
        model.addAttribute("vacancy", vacancy);
        return "redirect:/vacancies";
    }

    @RequestMapping(value = "/employer/{employerId}", method = RequestMethod.GET)
    public String getEmployer(@PathVariable Long employerId, Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) auth.getPrincipal();
        User user = userService.getUserByEmail(userDetails.getUsername());

        model.addAttribute("currentUser", user);
        model.addAttribute("employer", employerRepository.findOne(employerId));
        return "employer";
    }

    @RequestMapping(value = "/register-employee", method = RequestMethod.POST)
    public String registerEmployee(@ModelAttribute EmployeeRegistrationFrom employeeRegistrationFrom) {
        userService.create(employeeRegistrationFrom);
        return "redirect:/";
    }

    @RequestMapping(value = "/register-employer", method = RequestMethod.POST)
    public String registerEmployer(@ModelAttribute EmployerRegistrationForm employerRegistrationForm) {
        userService.create(employerRegistrationForm);
        return "redirect:/";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(@RequestParam String error) {
        return new ModelAndView("login", "error", error);
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout() {
        return "redirect:/";
    }

    @RequestMapping(value = "/new-vacancy", method = RequestMethod.GET)
    public String createNewVacancyForm(Model model) {
        model.addAttribute("spheres", sphereRepositorry.findAll());
        model.addAttribute("regions", regionRepository.findAll());
        model.addAttribute("form", new VacancyCreationForm());

        return "new-vacancy";
    }

    @RequestMapping(value = "/new-vacancy", method = RequestMethod.POST)
    public String createNewVacancy(@ModelAttribute VacancyCreationForm vacancyCreationForm) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) auth.getPrincipal();
        User user = userService.getUserByEmail(userDetails.getUsername());
        Employer employer = employerRepository.findOneByUser(user);

        Vacancy vacancy = new Vacancy();
        vacancy.setTitle(vacancyCreationForm.getTitle());
        vacancy.setOffer(vacancyCreationForm.getOffer());
        vacancy.setRequirements(vacancyCreationForm.getRequirements());
        vacancy.setDescription(vacancyCreationForm.getDescription());
        vacancy.setEmployer(employer);
        Region region = regionRepository.findOne(vacancyCreationForm.getRegion());
        Sphere sphere = sphereRepositorry.findOne(vacancyCreationForm.getSphere());
        vacancy.setRegion(region);
        vacancy.setSphere(sphere);
        vacancyRepository.save(vacancy);

        System.out.println(vacancy.toString());

        return "redirect:/my-vacancies";
    }

    @RequestMapping(value = "/my-resumes", method = RequestMethod.GET)
    public String getMyResumes(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) auth.getPrincipal();
        User user = userService.getUserByEmail(userDetails.getUsername());
        model.addAttribute("resumes", resumeRepository.findAllByUser(user));

        return "my-resumes";
    }

    @RequestMapping(value = "/new-resume", method = RequestMethod.GET)
    public String getNewResumeForm(Model model) {
        model.addAttribute("spheres", sphereRepositorry.findAll());
        model.addAttribute("regions", regionRepository.findAll());
        model.addAttribute("form", new ResumeCreationForm());

        return "new-resume";
    }

    @RequestMapping(value = "/new-resume", method = RequestMethod.POST)
    public String getNewResumeForm(@ModelAttribute ResumeCreationForm resumeCreationForm) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) auth.getPrincipal();
        User user = userService.getUserByEmail(userDetails.getUsername());

        Resume resume = new Resume();
        resume.setTitle(resumeCreationForm.getTitle());
        resume.setSalary(resumeCreationForm.getSalary());
        resume.setAdditionalInformation(resumeCreationForm.getAdditionalInformation());
        Region region = regionRepository.findOne(resumeCreationForm.getRegion());
        Sphere sphere = sphereRepositorry.findOne(resumeCreationForm.getSphere());
        resume.setRegion(region);
        resume.setSphere(sphere);
        resume.setUser(user);
        resumeRepository.save(resume);

        Education education = new Education();
        education.setInstitution(resumeCreationForm.getInstitution());
        education.setDegree(resumeCreationForm.getDegree());
        education.setSpeciality(resumeCreationForm.getSpeciality());
        education.setCity(resumeCreationForm.getInstitutionCity());
        education.setStartDate(new Date());
        education.setEndDate(new Date());
        education.setAdditionalInformation(resumeCreationForm.getEducationAdditional());
        education.setResume(resume);
        educationRepository.save(education);

        WorkExperience workExperience = new WorkExperience();
        workExperience.setCity(resumeCreationForm.getWorkRegion());
        workExperience.setCompanyName(resumeCreationForm.getCompanyName());
        workExperience.setSphere(resumeCreationForm.getWorkSphere());
        workExperience.setPosition(resumeCreationForm.getPosition());
        workExperience.setStartDate(new Date());
        workExperience.setEndDate(new Date());
        workExperience.setAdditionalInformation(resumeCreationForm.getWorkAdditional());
        workExperience.setResume(resume);
        workExperienceRepository.save(workExperience);

        return "redirect:/my-resumes";
    }

    @RequestMapping(value = "/my-vacancies", method = RequestMethod.GET)
    public String getMyVacanciesAsEmployer(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) auth.getPrincipal();
        User user = userService.getUserByEmail(userDetails.getUsername());
        Employer employer = employerRepository.findOneByUser(user);
        model.addAttribute("vacancies", vacancyRepository.findAllByEmployer(employer));

        return "my-vacancies";
    }

    @RequestMapping(value = "/vacancy/delete/{id}", method = RequestMethod.GET)
    public String deleteVacancy(@PathVariable Long id) {
        vacancyRepository.delete(id);
        return "redirect:/my-vacancies";
    }

    @RequestMapping(value = "/resume/delete/{id}", method = RequestMethod.GET)
    public String deleteResume(@PathVariable Long id) {
        resumeRepository.delete(id);
        return "redirect:/my-resumes";
    }

    @RequestMapping(value = "/my-vacancies-history", method = RequestMethod.GET)
    public String getMyVacancyHistory(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) auth.getPrincipal();
        User user = userService.getUserByEmail(userDetails.getUsername());
        Employer employer = employerRepository.findOneByUser(user);

        List<Vacancy> vacancies = vacancyRepository.findAllByEmployer(employer);
        List<VacancyHistory> histories = new ArrayList<>();
        for (Vacancy vacancy : vacancies) {
            List<VacancyHistory> currentHistories = vacancyHistoryRepository.findAllByVacancy(vacancy);
            histories.addAll(currentHistories);
        }

        model.addAttribute("vacancyHistories", histories);
        model.addAttribute("currentUser", user);

        return "my-vacancies-history";
    }
}
