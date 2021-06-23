package com.elasticlandlord.model;


import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.Objects;

@MappedSuperclass
// indicates these fields should also be stored in tables/rows
// created by classes that extend this abstract class
public abstract class AbstractIdEntity {

    @Id
    @GeneratedValue
    private int id;

    public int getId() {return id;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractIdEntity entity = (AbstractIdEntity) o;
        return id == entity.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
