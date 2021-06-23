package com.elasticlandlord.data;

import com.elasticlandlord.model.Property;
import org.springframework.data.repository.CrudRepository;

public interface PropertyRepository extends CrudRepository<Property, Integer> {
}
