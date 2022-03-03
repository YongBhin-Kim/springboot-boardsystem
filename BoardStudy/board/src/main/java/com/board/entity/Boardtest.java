package com.board.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "board")
@Data
public class Boardtest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title = "title입니다";
    
    private String content = "content입니다";

    // @Column(columnDefinition = "varchar(45) default 'TITLE'")
    // @Column(columnDefinition = "TEXT default 'CONTENT'")
    // public void print(){
    //     System.out.println("Board 내부");
    // }
}

