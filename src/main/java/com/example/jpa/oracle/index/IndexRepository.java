package com.example.jpa.oracle.index;

import com.example.jpa.oracle.domain.TestTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IndexRepository extends JpaRepository<TestTable, Integer> {

    @Query(value = "select * from TEST_TABLE where col1 =  :col1", nativeQuery = true)
    TestTable findByCol1(int col1);


}
