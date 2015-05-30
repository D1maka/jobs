package jobs.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by dmytro_veres on 28.05.2015.
 */
@Entity
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
}
