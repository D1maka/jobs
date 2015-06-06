package jobs.service;

import jobs.entities.User;
import jobs.service.forms.EmployeeRegistrationFrom;
import jobs.service.forms.EmployerRegistrationForm;

import java.util.Collection;

/**
 * Created by dmytro_veres on 06.06.2015.
 */
public interface UserService {
    User getUserById(long id);

    User getUserByEmail(String email);

    Iterable<User> getAllUsers();

    User create(User user);

    User create(EmployerRegistrationForm employerRegistrationForm);

    User create(EmployeeRegistrationFrom employeeRegistrationForm);
}
