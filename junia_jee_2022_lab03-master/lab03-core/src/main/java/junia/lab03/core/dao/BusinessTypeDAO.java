package junia.lab03.core.dao;

import junia.lab03.core.entity.BusinessType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusinessTypeDAO extends JpaRepository<BusinessType,Long> {
}
