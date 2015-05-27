package jobs.entities;

import javax.persistence.*;

/**
 * Created by dmytro_veres on 28.05.2015.
 */
@Entity
public class Sphere {
    @Id
    @Column(name = "idsphere")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "spherename")
    private String name;

    public Sphere() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
