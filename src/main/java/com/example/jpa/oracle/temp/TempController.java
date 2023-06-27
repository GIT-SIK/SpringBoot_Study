package com.example.jpa.oracle.temp;

import com.example.jpa.oracle.domain.TestTable;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Slf4j
public class TempController {

    @Autowired
    TempService tempService;

    @GetMapping("/v/test")
    public String IndexLog(Model m){
        String sLog = " #### INDEX TEST ####";
        log.info("출력 : " + sLog);
        m.addAttribute("logdata",sLog );
        return "log";
    }

    @GetMapping("/v/col")
    public String TestCol(Model m) {
        return "col";
    }

    @GetMapping("/v/all")
    public String TestAll(Model m) {
        log.info("출력 : " + tempService.findAll());
        m.addAttribute("print",tempService.findAll());
        return "print";
    }

    @RequestMapping(value = "/i/col", method = RequestMethod.POST)
    public ModelAndView TestICol(ModelAndView mav, @RequestParam(value="col1", required = false) String col1) {
        log.info("입력 : " + col1);
        TestTable tt = new TestTable();
        try {
            tt = tempService.findbyCol1(Integer.parseInt(col1));
            log.info("처리 : FindBy");
        } catch (Exception e) {
            System.out.println(e);
            log.error("오류 : COL1 값");
        }

        log.info("출력 : " + tt);

        mav.setViewName("col");
        return mav;
    }

}
