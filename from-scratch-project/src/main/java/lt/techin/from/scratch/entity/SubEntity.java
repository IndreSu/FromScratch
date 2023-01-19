package lt.techin.from.scratch.entity;

import javax.persistence.*;
import javax.persistence.Entity;

@Entity
public class SubEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne (fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @JoinColumn(name = "entity_id")
    private lt.techin.from.scratch.entity.Entity entity; //del name konflikto. t.b. tiesiog Entity entity;

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

    public lt.techin.from.scratch.entity.Entity getEntity() {
        return entity;
    }

    public void setEntity(lt.techin.from.scratch.entity.Entity entity) {
        this.entity = entity;
    }
}
