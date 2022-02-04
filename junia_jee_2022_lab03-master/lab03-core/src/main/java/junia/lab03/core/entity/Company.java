package junia.lab03.core.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

//TODO annotate this entity
@Entity
@JsonIgnoreProperties(value = { "projects" })
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long id;

    private String name;

    @OneToMany(mappedBy = "company")

    private List<Project> projects;


    public Company() {
    }


    public long getId() {
        return id;
    }


    public String getName() {
        return name;
    }


    public void setName(final String nameValue) {
        name = nameValue;
    }


    public List<Project> getProjects() {
        return projects;
    }


    public void setProjects(final List<Project> projectsValue) {
        projects = projectsValue;
    }


}
