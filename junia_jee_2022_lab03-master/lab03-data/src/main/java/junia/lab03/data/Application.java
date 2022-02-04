package junia.lab03.data;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import junia.lab03.core.entity.BusinessType;
import junia.lab03.core.entity.Company;
import junia.lab03.core.entity.Customer;
import junia.lab03.core.entity.Project;
import junia.lab03.core.service.BusinessTypeService;
import junia.lab03.core.service.CompanyService;
import junia.lab03.core.service.CustomerService;
import junia.lab03.core.service.ProjectService;

import java.util.HashMap;
import java.util.Map;

public class Application {

    public static void main(String[] args) {
        final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("junia.lab03.core.config");
        final CompanyService companyService = context.getBean(CompanyService.class);
        final BusinessTypeService businessTypeService = context.getBean(BusinessTypeService.class);
        final CustomerService customerService = context.getBean(CustomerService.class);
        final ProjectService projectService = context.getBean(ProjectService.class);
        cleanDB(companyService, businessTypeService, customerService, projectService);
        final Map<String, Company> companies = registerCompanies(companyService);
        final Map<String, BusinessType> businessTypes = registerBusinessTypes(businessTypeService);
        final Map<String, Customer> customers = registerCustomers(customerService, businessTypes);
        final Map<String, Project> projects = registerProjects(projectService, companies, customers);
    }


    private static void cleanDB(final CompanyService companyService, final BusinessTypeService businessTypeService, final CustomerService customerService,
            final ProjectService projectService) {
        projectService.deleteAll();
        companyService.deleteAll();
        customerService.deleteAll();
        businessTypeService.deleteAll();
        projectService.deleteAll();
    }


    private static Map<String, Company> registerCompanies(final CompanyService companyService) {
        Map<String, Company> companies = new HashMap<>();
        companies.put("worldline", createCompany("Worldline", companyService));
        companies.put("sopra", createCompany("Sopra Steria", companyService));
        companies.put("atos", createCompany("Atos", companyService));
        companies.put("cap", createCompany("Cap Gemini", companyService));
        companies.put("cgi", createCompany("CGI", companyService));
        return companies;
    }


    private static Company createCompany(String companyName, final CompanyService companyService) {
        System.out.println("Registring " + companyName);
        Company company = new Company();
        company.setName(companyName);
        companyService.save(company);
        return company;
    }


    private static Map<String, BusinessType> registerBusinessTypes(final BusinessTypeService businessTypeService) {
        Map<String, BusinessType> types = new HashMap<>();
        types.put("retail", createBusinessType("retail", businessTypeService));
        types.put("healthcare", createBusinessType("healthcare", businessTypeService));
        types.put("phone", createBusinessType("phone", businessTypeService));
        types.put("aero", createBusinessType("aeronautics", businessTypeService));
        types.put("food", createBusinessType("food", businessTypeService));
        return types;
    }


    private static BusinessType createBusinessType(String name, final BusinessTypeService businessTypeService) {
        System.out.println("Registring " + name);
        BusinessType businessType = new BusinessType();
        businessType.setName(name);
        businessTypeService.save(businessType);
        return businessType;
    }


    private static Map<String, Customer> registerCustomers(final CustomerService customerService, final Map<String, BusinessType> businessTypes) {
        Map<String, Customer> customers = new HashMap<>();
        customers.put("auchan", createCustomer("Auchan", businessTypes.get("retail"), customerService));
        customers.put("carrefour", createCustomer("Carrefour", businessTypes.get("retail"), customerService));
        customers.put("walmart", createCustomer("Walmart", businessTypes.get("retail"), customerService));
        customers.put("philips", createCustomer("Philips", businessTypes.get("healthcare"), customerService));
        customers.put("ge", createCustomer("GE", businessTypes.get("healthcare"), customerService));
        customers.put("orange", createCustomer("Orange", businessTypes.get("phone"), customerService));
        customers.put("airbus", createCustomer("Airbus", businessTypes.get("aero"), customerService));
        customers.put("boeing", createCustomer("Boeing", businessTypes.get("aero"), customerService));
        customers.put("kraft", createCustomer("Kraft", businessTypes.get("food"), customerService));
        customers.put("nestle", createCustomer("Nestle", businessTypes.get("food"), customerService));
        return customers;
    }


    private static Customer createCustomer(String name, final BusinessType businessType, final CustomerService customerService) {
        System.out.println("Registring " + name);
        Customer customer = new Customer();
        customer.setName(name);
        customer.setBusinessType(businessType);
        customerService.save(customer);
        return customer;
    }


    private static Map<String, Project> registerProjects(final ProjectService projectService, final Map<String, Company> companies,
            final Map<String, Customer> customers) {
        Map<String, Project> projects = new HashMap<>();
        projects.put("webmail", createProject("Webmail refactoring", companies.get("worldline"), customers.get("orange"), projectService));
        projects.put("legacy", createProject("Legacy project", companies.get("atos"), customers.get("boeing"), projectService));
        projects.put("digital", createProject("Digital transformation", companies.get("cap"), customers.get("kraft"), projectService));
        projects.put("5g", createProject("5G deployment", companies.get("sopra"), customers.get("orange"), projectService));
        projects.put("cloud", createProject("Cloud storage", companies.get("sopra"), customers.get("orange"), projectService));
        projects.put("rfid", createProject("RFID update", companies.get("sopra"), customers.get("orange"), projectService));
        projects.put("mobile", createProject("Mobile App", companies.get("cgi"), customers.get("nestle"), projectService));
        projects.put("mobile2", createProject("Mobile App", companies.get("cap"), customers.get("nestle"), projectService));
        projects.put("5g2", createProject("5G deployment", companies.get("worldline"), customers.get("orange"), projectService));
        projects.put("amoa", createProject("Project Management", companies.get("atos"), customers.get("airbus"), projectService));
        projects.put("payment", createProject("Payment system", companies.get("worldline"), customers.get("auchan"), projectService));
        projects.put("web", createProject("Webstore", companies.get("worldline"), customers.get("walmart"), projectService));
        return projects;
    }


    private static Project createProject(String name, final Company company, final Customer customer, final ProjectService projectService) {
        System.out.println("Registring " + name);
        Project project = new Project();
        project.setName(name);
        project.setCompany(company);
        project.setCustomer(customer);
        projectService.save(project);
        return project;
    }
}
