package jobs.entities;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by dmytro_veres on 30.05.2015.
 */
@Entity
@Table(name = "resume_history")
public class ResumeHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idresume_history")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "resumeid")
    private Resume resume;

    @ManyToOne
    @JoinColumn(name = "employerid")
    private Employer employer;

    @Column(name = "date")
    private Date date;

    public ResumeHistory() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Resume getResume() {
        return resume;
    }

    public void setResume(Resume resume) {
        this.resume = resume;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
