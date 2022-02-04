package junia.lab03.core.service;

import junia.lab03.core.dao.BusinessTypeDAO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import junia.lab03.core.entity.BusinessType;

@Service
@Transactional
public class BusinessTypeService {
    //TODO inject a DAO

    private BusinessTypeDAO businessTypeDAO;

    public BusinessTypeService(BusinessTypeDAO businessTypeDAO) {
        this.businessTypeDAO = businessTypeDAO;
    }

    public void deleteAll() {
        //TODO implement
        businessTypeDAO.deleteAll();
    }


    public void save(final BusinessType businessType) {
        //TODO implement
        businessTypeDAO.save(businessType);
    }


    public long countAll() {
        //TODO implement
        return businessTypeDAO.count();
    }
}
