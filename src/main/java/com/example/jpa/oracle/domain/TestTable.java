package com.example.jpa.oracle.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Data
@Entity
@Table(name="TEST_TABLE")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TestTable{

    @Id
    @Column(name = "COL1")
    private int col1;

    @Column(name = "COL2")
    private String col2;
}
