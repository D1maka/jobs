package jobs.service.forms;

import java.util.Date;

/**
 * Created by dmytro_veres on 07.06.2015.
 */
public class ResumeCreationForm {
    private String title;
    private Long sphere;
    private Long region;
    private Double salary;
    private String additionalInformation;

    private String institution;
    private String speciality;
    private String institutionCity;
    private String degree;
//    private Date educationStartYear;
//    private Date educationEndYear;
    private String educationAdditional;

    private String companyName;
    private String workRegion;
    private String position;
    private String workSphere;
//    private Date workStartYear;
//    private Date workEndYear;
    private String workAdditional;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getSphere() {
        return sphere;
    }

    public void setSphere(Long sphere) {
        this.sphere = sphere;
    }

    public Long getRegion() {
        return region;
    }

    public void setRegion(Long region) {
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

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String getInstitutionCity() {
        return institutionCity;
    }

    public void setInstitutionCity(String institutionCity) {
        this.institutionCity = institutionCity;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

//    public Date getEducationStartYear() {
//        return educationStartYear;
//    }
//
//    public void setEducationStartYear(Date educationStartYear) {
//        this.educationStartYear = educationStartYear;
//    }

//    public Date getEducationEndYear() {
//        return educationEndYear;
//    }
//
//    public void setEducationEndYear(Date educationEndYear) {
//        this.educationEndYear = educationEndYear;
//    }

    public String getEducationAdditional() {
        return educationAdditional;
    }

    public void setEducationAdditional(String educationAdditional) {
        this.educationAdditional = educationAdditional;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getWorkRegion() {
        return workRegion;
    }

    public void setWorkRegion(String workRegion) {
        this.workRegion = workRegion;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getWorkSphere() {
        return workSphere;
    }

    public void setWorkSphere(String workSphere) {
        this.workSphere = workSphere;
    }

//    public Date getWorkStartYear() {
//        return workStartYear;
//    }
//
//    public void setWorkStartYear(Date workStartYear) {
//        this.workStartYear = workStartYear;
//    }

//    public Date getWorkEndYear() {
//        return workEndYear;
//    }
//
//    public void setWorkEndYear(Date workEndYear) {
//        this.workEndYear = workEndYear;
//    }

    public String getWorkAdditional() {
        return workAdditional;
    }

    public void setWorkAdditional(String workAdditional) {
        this.workAdditional = workAdditional;
    }
}
