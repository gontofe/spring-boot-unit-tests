package com.michaelrichardhall.springboottest;

import com.michaelrichardhall.springboottest.persistence.model.Employee;
import com.michaelrichardhall.springboottest.persistence.repo.EmployeeRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = SpringboottestApplication.class)
@AutoConfigureMockMvc
@TestPropertySource(
        locations = "classpath:application-integrationtest.properties")
public class EmployeeRestControllerIntegrationTest {
        @Autowired
        private MockMvc mvc;

        @Autowired
        private EmployeeRepository employeeRepository;

        @Test
        public void givenEmployees_whenGetEmployees_thenStatus200() throws Exception {
            createTestEmployee("bob");

            mvc.perform(get("/api/employees")
                    .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andExpect(content()
                    .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                    .andExpect(jsonPath("$[0].name", is("bob")));
        }

    private void createTestEmployee(String name) {
        Employee employee = new Employee(name);
        employeeRepository.saveAndFlush(employee);
    }
}
