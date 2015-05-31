package jobs.entities;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by dmytro_veres on 30.05.2015.
 */
@Entity
@Table(name = "vacancy_history")
public class VacancyHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idvacancy_history")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "vacancyid")
    private Vacancy vacancy;

    @ManyToOne
    @JoinColumn(name = "resumeid")
    private Resume resume;

    @Column(name = "date")
    private Date date;

    public VacancyHistory() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Vacancy getVacancy() {
        return vacancy;
    }

    public void setVacancy(Vacancy vacancy) {
        this.vacancy = vacancy;
    }

    public Resume getResume() {
        return resume;
    }

    public void setResume(Resume resume) {
        this.resume = resume;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
