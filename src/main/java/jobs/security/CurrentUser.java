package jobs.security;

import jobs.entities.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

/**
 * Created by dmytro_veres on 06.06.2015.
 */
public class CurrentUser extends User {

    private jobs.entities.User user;

    public CurrentUser(jobs.entities.User user) {
        super(user.getEmail(), user.getPasswordHash(), AuthorityUtils.createAuthorityList(user.getRole().toString()));
        this.user = user;
    }

    public jobs.entities.User getUser() {
        return this.user;
    }

    public Long getId() {
        return this.user.getId();
    }

    public Role getRole() {
        return this.user.getRole();
    }
}
