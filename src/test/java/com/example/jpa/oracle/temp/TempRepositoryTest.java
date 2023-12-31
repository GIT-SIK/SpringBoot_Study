package com.example.jpa.oracle.temp;


import com.example.jpa.oracle.domain.TestTable;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class TempRepositoryTest {

    @Autowired
    private TempRepository tempRepository;



    @Test
    //@Rollback(false) 테스트 종료 이후 ROLLBACK 비활성화
    public void indexSave(){

        final int dcol1 = 8;
        TestTable testTable = TestTable.builder().col1(dcol1).col2("Test").build();

        TestTable testTableSave = tempRepository.save(testTable);
        System.out.println("SAVE : "+ testTableSave);
        System.out.println(tempRepository.findByCol1(dcol1));
    }
}
