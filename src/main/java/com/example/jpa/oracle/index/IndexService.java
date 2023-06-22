package com.example.jpa.oracle.index;

import com.example.jpa.oracle.domain.TestTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IndexService {

    @Autowired
    IndexRepository indexRepository;

    public TestTable findbyCol1(int x) {
        return indexRepository.findByCol1(x);
    }
}
