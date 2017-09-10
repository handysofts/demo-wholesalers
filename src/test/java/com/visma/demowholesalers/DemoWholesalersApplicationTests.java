package com.visma.demowholesalers;

import com.visma.demowholesalers.enums.Errors;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class DemoWholesalersApplicationTests {
    private static final String PRODUCT_PRICE_CALCULATION_URL = "/api/v1/product/price/calculation/customer/%d/product/%d/quantity/%d";

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void contextLoads() {
    }

    @Test
    public void productControllerDiscountNoneCustomerTest() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get(String.format(PRODUCT_PRICE_CALCULATION_URL, 0, 1, 1)))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString(Errors.NOT_FOUND_CUSTOMER.getText())));
    }


    @Test
    public void productControllerDiscountNoneProductTest() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get(String.format(PRODUCT_PRICE_CALCULATION_URL, 1, 0, 1)))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString(Errors.NOT_FOUND_PRODUCT.getText())));
    }


    @Test
    public void productControllerDiscountOkTest() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get(String.format(PRODUCT_PRICE_CALCULATION_URL, 1, 1, 1)))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString(Errors.OK.getText())));
    }
}
