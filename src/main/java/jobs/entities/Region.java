package jobs.entities;

import javax.persistence.*;

/**
 * Created by dmytro_veres on 28.05.2015.
 */
@Entity
public class Region {
    @Id
    @Column(name = "idregion")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "regionname")
    private String name;

    public Region() {
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
}
