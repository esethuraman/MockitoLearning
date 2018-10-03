package org.esethuraman.mockito.practise.MockitoWithSpringBoot;

import org.esethuraman.mockito.practise.MockitoWithSpringBoot.domain.Item;
import org.esethuraman.mockito.practise.MockitoWithSpringBoot.service.ItemService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
@RunWith(SpringRunner.class)
public class ItemControllerUnitTests {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    ItemService itemService;
    /*
    content.json is better than content.string as it is very flexible in terms of validation unlike
    string which looks for exact match character by character
     */
    @Test
    public void item() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/item");

        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("{id: 1, name: item1, price: 15, quantity: 10}"))
                // we can even validate the subset of the response
                .andExpect(content().json("{price: 15}"));
    }

    /*
    to mock a controller that invokes a service, the service bean must be mocked in prior. Here We have mocked the
    bean itemService using @MockBean. then use when..then clause on the mocked bean. Once it is done, the controller
    can be comfortably mocked
     */
    @Test
    public void itemFromService() throws Exception {

        when(itemService.getItem()).thenReturn(new Item(1,"itemFromService", 15, 10));

        RequestBuilder request = MockMvcRequestBuilders.get("/itemFromService");

        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("{id: 1, name: itemFromService, price: 15, quantity: 10}"));
    }

}
