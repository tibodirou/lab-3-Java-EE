package junia.lab03.web.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import junia.lab03.core.service.BusinessTypeService;
import junia.lab03.core.service.CompanyService;
import junia.lab03.core.service.CustomerService;
import junia.lab03.core.service.ProjectService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

@WebServlet(urlPatterns = "/api/*")
public class ApiServlet extends HttpServlet {

    private ProjectService projectService;

    private CompanyService companyService;

    private BusinessTypeService businessTypeService;

    private CustomerService customerService;

    private Map<String, Consumer<PrintWriter>> routes;

    private ObjectMapper objectMapper;


    @Override
    public void init() throws ServletException {
        final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("junia.lab03.core.config");
        companyService = context.getBean(CompanyService.class);
        businessTypeService = context.getBean(BusinessTypeService.class);
        customerService = context.getBean(CustomerService.class);
        projectService = context.getBean(ProjectService.class);
        objectMapper = new ObjectMapper();
        routes = new HashMap<>();
        routes.put("/counts", getCounts());
        routes.put("/nb-projects-by-company", getNbProjectsByCompany());
        routes.put("/projects", getFullProjects());
    }


    private Consumer<PrintWriter> getCounts() {
        return (writer) -> {
            writer.println("Companies:" + companyService.countAll());
            writer.println("Customers:" + customerService.countAll());
            writer.println("BusinessTypes:" + businessTypeService.countAll());
            writer.println("Projects:" + projectService.countAll());
        };
    }


    private Consumer<PrintWriter> getNbProjectsByCompany() {
        return (writer) -> {
            Map<String, Integer> all = companyService.getAllWithProjectCount();
            all.forEach((k, v) -> writer.println(k + ":" + v));
        };
    }

    private Consumer<PrintWriter> getFullProjects() {
        return (writer) -> {
            try {
                writer.write(objectMapper.writeValueAsString(projectService.findAll()));
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        };
    }


    @Override
    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        final PrintWriter writer = resp.getWriter();
        routes.get(req.getPathInfo()).accept(writer);
    }
}
