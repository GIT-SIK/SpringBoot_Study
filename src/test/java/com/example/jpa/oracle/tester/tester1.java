package com.example.jpa.oracle.tester;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Slf4j
public class tester1 {

    @Autowired
    private MockMvc mm;


    @Test
    public void test() throws Exception{
        try {
            mm.perform(get("/log")).andExpect(status().isOk());
        } catch (Exception e){
            log.error("####ER#### \n" + e);
        }
    }
}

