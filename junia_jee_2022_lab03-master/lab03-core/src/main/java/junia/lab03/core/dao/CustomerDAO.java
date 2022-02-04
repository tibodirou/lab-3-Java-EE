package junia.lab03.core.dao;

import junia.lab03.core.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerDAO extends JpaRepository <Customer,Long> {
}
