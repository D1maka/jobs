package jobs.entities;

import javax.persistence.*;

/**
 * Created by dmytro_veres on 28.05.2015.
 */
@Entity
@Table(name = "vacancy")
public class Vacancy {
    @Id
    @Column(name = "idvacancy")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "requirements")
    private String requirements;

    @Column(name = "offer")
    private String offer;

    @ManyToOne
    @JoinColumn(name = "locationid")
    private Region region;

    @ManyToOne
    @JoinColumn(name = "sphereid")
    private Sphere sphere;

    @ManyToOne
    @JoinColumn(name = "employerid")
    private Employer employer;

    public Vacancy() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRequirements() {
        return requirements;
    }

    public void setRequirements(String requirements) {
        this.requirements = requirements;
    }

    public String getOffer() {
        return offer;
    }

    public void setOffer(String offer) {
        this.offer = offer;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public Sphere getSphere() {
        return sphere;
    }

    public void setSphere(Sphere sphere) {
        this.sphere = sphere;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }
}
