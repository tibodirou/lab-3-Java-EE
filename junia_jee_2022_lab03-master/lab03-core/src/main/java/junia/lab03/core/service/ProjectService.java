package junia.lab03.core.service;

import junia.lab03.core.dao.ProjectDAO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import junia.lab03.core.entity.Project;

import java.util.List;

@Service
@Transactional
public class ProjectService {


    private ProjectDAO projectDAO;

    public ProjectService(ProjectDAO projectDAO) {
        this.projectDAO = projectDAO;
    }

    public void deleteAll() {
        //TODO implement
        projectDAO.deleteAll();
    }

    public void save(Project project){
        //TODO implement
        projectDAO.save(project);
    }

    public long countAll() {
        //TODO implement
        return projectDAO.count();
    }

    public List<Project> findAll(){
        //TODO implement
        return projectDAO.findAll();
    }
}
