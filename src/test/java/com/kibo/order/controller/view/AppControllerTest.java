package com.kibo.order.controller.view;

import com.kibo.order.AppInitializer;
import com.kibo.order.service.service.EmployeeService;
import com.kibo.order.data.entity.embeddable.Name;
import com.kibo.order.data.entity.entity.Employee;
import org.joda.time.LocalDate;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Collections;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

//@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppInitializer.class})
//@WebAppConfiguration not needed because AppInitializer.class implements WebApplicationInitializer
public class AppControllerTest {

    private MockMvc mockMvc;

    @Mock
    private EmployeeService employeeService;

    @InjectMocks
    private AppController appControllerUnderTest;

    @Before
    public void setup() {

        // this must be called for the @Mock annotations above to be processed
        // and for the mock service to be injected into the controller under
        // test.
        // or just uncomment @RunWith(MockitoJUnitRunner.class)
        MockitoAnnotations.initMocks(this);

        mockMvc = MockMvcBuilders.standaloneSetup(appControllerUnderTest).build();
    }

    @Test
    public void test() throws Exception {

        // start set up
        Employee a = new Employee();
        a.setName("Marcus");
        a.setBirthDate(new LocalDate());
        Name name = new Name();
        name.setFirst("Marcus");
        name.setMiddle("R");
        name.setLast("Chiu");
        a.setNameTwo(name);

        when(employeeService.findAllEmployees()).thenReturn(Collections.singletonList(a));
        // end set up


        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.get("/"))
                .andExpect(status().isOk());

        // print result to the console, for debugging
        MvcResult mvcResult = resultActions
                .andDo(print())
                .andReturn();

//        String content = mvcResult.getResponse().getContentAsString();
//        System.err.println(content);

        // check results
        resultActions
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.TEXT_HTML_VALUE))
                .andExpect(forwardedUrl("allemployees"));

        verify(employeeService, times(1)).findAllEmployees();
        verifyNoMoreInteractions(employeeService);
    }
}
