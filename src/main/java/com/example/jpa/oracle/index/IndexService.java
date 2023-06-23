package com.example.jpa.oracle.index;

import com.example.jpa.oracle.domain.TestTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IndexService {

    @Autowired
    IndexRepository indexRepository;

    public List<TestTable> findAll() { return indexRepository.findAll(); }
    public TestTable findbyCol1(int x) {
        return indexRepository.findByCol1(x);
    }
}
