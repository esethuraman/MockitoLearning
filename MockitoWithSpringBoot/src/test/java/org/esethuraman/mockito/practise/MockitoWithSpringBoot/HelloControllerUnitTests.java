package org.esethuraman.mockito.practise.MockitoWithSpringBoot;

import org.esethuraman.mockito.practise.MockitoWithSpringBoot.controller.HelloController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest
public class HelloControllerUnitTests {

    // this is the mock bean that is used to mock objects
    // since this is a bean by itself, it can be autowired
    @Autowired
    MockMvc mockMvc;

    @Test
    public void helloController_TrivialAssert(){
        HelloController helloController = new HelloController();
        assertEquals(helloController.hello(),"Hello World!");
    }

    @Test
    public void helloController_mockTestTwoExternalAssert() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders
                .get("/hello")
                .accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(request).andReturn();
        assertEquals("Hello World!", result.getResponse().getContentAsString());

    }

    /*
    In this test, instead of using a separate assert statement, the ResultMatcher of Mockito
    is used whose status() and content() methods performs the assertion
     */
    @Test
    public void helloController_mockEmbeddedAssertTest() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders
                .get("/hello")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("Hello World!"))
                .andReturn();
    }
}
