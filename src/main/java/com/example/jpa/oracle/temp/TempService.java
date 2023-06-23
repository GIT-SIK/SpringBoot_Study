package com.example.jpa.oracle.temp;

import com.example.jpa.oracle.domain.TestTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TempService {

    @Autowired
    TempRepository tempRepository;

    public List<TestTable> findAll() { return tempRepository.findAll(); }
    public TestTable findbyCol1(int x) {
        return tempRepository.findByCol1(x);
    }
}
