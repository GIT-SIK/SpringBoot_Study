package com.example.jpa.oracle.index;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class IndexController {
    @GetMapping("/log")
    public String IndexLog(Model model){
        String sLog = " #### INDEX LOG TEST ####";
        log.info(sLog);
        model.addAttribute("logdata",sLog );
        return "log.html";
    }
}
