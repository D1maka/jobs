package jobs.service;

import jobs.entities.Employer;
import jobs.entities.Role;
import jobs.entities.User;
import jobs.repository.EmployerRepository;
import jobs.repository.UserRepository;
import jobs.service.forms.EmployeeRegistrationFrom;
import jobs.service.forms.EmployerRegistrationForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Created by dmytro_veres on 06.06.2015.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EmployerRepository employerRepository;

    @Override
    public User getUserById(long id) {
        return userRepository.findOne(id);
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.findOne(3L);
    }

    @Override
    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User create(User user) {
        return userRepository.save(user);
    }

    @Override
    public User create(EmployerRegistrationForm employerRegistrationForm) {
        User user = new User();
        user.setFirstName(employerRegistrationForm.getFirstName());
        user.setLastName(employerRegistrationForm.getLastName());
        user.setEmail(employerRegistrationForm.getEmail());
        user.setPasswordHash(new BCryptPasswordEncoder().encode(employerRegistrationForm.getPassword()));
        user.setRole(Role.EMPLOYER);
        userRepository.save(user);
        Employer employer = new Employer();
        employer.setName(employerRegistrationForm.getCompanyName());
        employer.setDescription(employerRegistrationForm.getDescription());
        employer.setUser(user);
        employerRepository.save(employer);
        return user;
    }

    @Override
    public User create(EmployeeRegistrationFrom employeeRegistrationForm) {
        User user = new User();
        user.setFirstName(employeeRegistrationForm.getFirstName());
        user.setLastName(employeeRegistrationForm.getLastName());
        user.setEmail(employeeRegistrationForm.getEmail());
        user.setPasswordHash(new BCryptPasswordEncoder().encode(employeeRegistrationForm.getPassword()));
        user.setRole(Role.EMPLOYEE);
        return userRepository.save(user);
    }
}
