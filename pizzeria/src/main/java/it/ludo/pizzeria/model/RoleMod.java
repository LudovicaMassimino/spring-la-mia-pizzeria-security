package it.ludo.pizzeria.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

@Entity
public class RoleMod {

    @Id
    private Integer id;

    @NotNull
    private String name;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}

