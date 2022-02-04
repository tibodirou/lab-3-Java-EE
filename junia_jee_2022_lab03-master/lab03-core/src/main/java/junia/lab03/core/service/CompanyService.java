package junia.lab03.core.service;

import junia.lab03.core.dao.CompanyDAO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import junia.lab03.core.entity.Company;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class CompanyService {
    //TODO inject a DAO
    private CompanyDAO companyDAO;


    public void deleteAll() {
        //TODO implement
        companyDAO.deleteAll();
    }

    public CompanyService(CompanyDAO companyDAO) {
        this.companyDAO = companyDAO;
    }

    public void save(final Company company) {
        //TODO implement
        companyDAO.save(company);
    }


    public long countAll() {
        //TODO implement
        return companyDAO.count();
    }


    public Map<String, Integer> getAllWithProjectCount() {
        //TODO return a map with the name of the company for the key and the count in the value
        List<Company> companies = companyDAO.findAll();
        Map<String,Integer> projectCounts = new HashMap<>();
        for(Company company:companies){
            projectCounts.put(company.getName(),company.getProjects().size());
        }
        return projectCounts;
    }
}
