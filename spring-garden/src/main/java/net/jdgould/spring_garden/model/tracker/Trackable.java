//Trackable.java
package net.jdgould.spring_garden.model.tracker;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Trackable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "trackable_id")
    private Long id;

    @Column(name = "trackable_name", nullable = false)
    private String name;

    protected Trackable() {
    }

    public Trackable(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}