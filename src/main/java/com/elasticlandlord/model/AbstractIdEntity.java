package com.elasticlandlord.model;


import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

public abstract class AbstractIdEntity {

    @Id
    @GeneratedValue
    private in id;

    public int getId() {return id;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return id == event.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
