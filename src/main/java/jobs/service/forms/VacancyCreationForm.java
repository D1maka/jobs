package jobs.service.forms;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by dmytro_veres on 07.06.2015.
 */
public class VacancyCreationForm {
    @NotEmpty
    private String title;
    @NotEmpty
    private String description;
    @NotEmpty
    private String requirements;
    @NotEmpty
    private String offer;
    @NotEmpty
    private Long sphereid;
    @NotEmpty
    private Long regionid;

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

    public Long getSphere() {
        return sphereid;
    }

    public void setSphere(Long sphere) {
        this.sphereid = sphere;
    }

    public Long getRegion() {
        return regionid;
    }

    public void setRegion(Long region) {
        this.regionid = region;
    }
}
