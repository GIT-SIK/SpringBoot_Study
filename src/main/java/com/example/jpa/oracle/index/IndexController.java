package com.example.jpa.oracle.index;

import com.example.jpa.oracle.domain.TestTable;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Slf4j
public class IndexController {

    @Autowired
    IndexService indexService;

    @GetMapping("/v/log")
    public String IndexLog(Model m){
        String sLog = " #### INDEX LOG TEST ####";
        log.info(sLog);
        m.addAttribute("logdata",sLog );
        return "log.html";
    }

    @GetMapping("/v/col")
    public String IndexCol(Model model) {
        return "col.html";
    }

    @RequestMapping(value = "/i/col", method = RequestMethod.POST)
    public ModelAndView IndexICol(ModelAndView mav, @RequestParam(value="col1", required = false) String col1) {
        log.info("입력 : " + col1);
        TestTable tt = new TestTable();
        try {
            tt = indexService.findbyCol1(Integer.parseInt(col1));
            log.info("처리 : FindBy");
        } catch (Exception e) {
            System.out.println(e);
            log.error("오류 : COL1 값");
        }

        log.info("출력 : " + tt);

        mav.setViewName("col.html");
        return mav;
    }

}
