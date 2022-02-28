package com.board.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


@Entity
@Table(name = "board")
@Data
// @DynamicInsert

public class Board {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "varchar(45) default 'TITLE'")
    private String title = "title";

    @Column(columnDefinition = "TEXT default 'CONTENT'")
    private String content = "content";

}
