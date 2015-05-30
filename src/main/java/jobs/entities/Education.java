package jobs.entities;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by dmytro_veres on 30.05.2015.
 */
@Entity
public class Education {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ideducation")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "institution")
    private Resume institution;

    @Column(name = "speciality")
    private String speciality;

    @Column(name = "city")
    private String city;

    @Column(name = "degree")
    private String degree;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @Column(name = "additional_information")
    private String additionalInformation;

    public Education() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Resume getInstitution() {
        return institution;
    }

    public void setInstitution(Resume institution) {
        this.institution = institution;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getAdditionalInformation() {
        return additionalInformation;
    }

    public void setAdditionalInformation(String additionalInformation) {
        this.additionalInformation = additionalInformation;
    }
}
