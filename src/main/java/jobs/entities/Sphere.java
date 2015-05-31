package jobs.entities;

import javax.persistence.*;

/**
 * Created by dmytro_veres on 28.05.2015.
 */
@Entity
@Table(name = "sphere")
public class Sphere {
    @Id
    @Column(name = "idsphere")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "spherename")
    private String name;

    public Sphere() {
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
