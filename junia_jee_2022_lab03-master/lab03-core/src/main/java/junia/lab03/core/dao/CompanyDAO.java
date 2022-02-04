package junia.lab03.core.dao;

import junia.lab03.core.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyDAO extends JpaRepository<Company,Long> {
}
