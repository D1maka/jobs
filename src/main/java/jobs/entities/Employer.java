package jobs.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dmytro_veres on 28.05.2015.
 */
@Entity
@Table(name = "employer")
public class Employer {
    @Id
    @Column(name = "idemployer")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "employername")
    @NotNull
    private String name;

    @Column(name = "description")
    @NotNull
    private String description;

    @OneToMany(mappedBy = "employer")
    private List<Vacancy> vacancyList = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "userid")
    private User user;

    public Employer() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Vacancy> getVacancyList() {
        return vacancyList;
    }

    public void setVacancyList(List<Vacancy> vacancyList) {
        this.vacancyList = vacancyList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
