package com.elasticlandlord.data;

import com.elasticlandlord.model.Tenant;
import org.springframework.data.repository.CrudRepository;

public interface TenantRepository extends CrudRepository<Tenant, Integer> {
}
