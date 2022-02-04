package junia.lab03.core.dao;

import junia.lab03.core.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectDAO extends JpaRepository<Project,Long> {
}
