package jobs.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dmytro_veres on 28.05.2015.
 */
@Entity
public class Resume {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idresume")
    private Long id;

    @Column(name = "title")
    private String title;

    @ManyToOne
    @JoinColumn(name = "sphereid")
    private Sphere sphere;

    @ManyToOne
    @JoinColumn(name = "regonid")
    private Region region;

    @Column(name = "salary")
    private Double salary;

    @Column(name = "additionalInformation")
    private String additionalInformation;

    @OneToMany(mappedBy = "resume")
    private List<Education> educationList = new ArrayList<>();

    @OneToMany(mappedBy = "resume")
    private List<WorkExperience> workExperienceList = new ArrayList<>();

    public Resume() {
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

    public Sphere getSphere() {
        return sphere;
    }

    public void setSphere(Sphere sphere) {
        this.sphere = sphere;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getAdditionalInformation() {
        return additionalInformation;
    }

    public void setAdditionalInformation(String additionalInformation) {
        this.additionalInformation = additionalInformation;
    }

    public List<Education> getEducationList() {
        return educationList;
    }

    public void setEducationList(List<Education> educationList) {
        this.educationList = educationList;
    }

    public List<WorkExperience> getWorkExperienceList() {
        return workExperienceList;
    }

    public void setWorkExperienceList(List<WorkExperience> workExperienceList) {
        this.workExperienceList = workExperienceList;
    }
}
