package com.board;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.boot.autoconfigure.domain.EntityScan;
// import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
// @EnableJpaRepositories(basePackages = {"com.board.repository"}) // com.my.jpa.repository 하위에 있는 jpaRepository를 상속한 repository scan
// @EntityScan(basePackages = {"com.board.entity"}) // com.my.jpa.entity 하위에 있는 @Entity 클래스 scan
public class BoardApplication {

	public static void main(String[] args) throws IOException{
		SpringApplication.run(BoardApplication.class, args);
	}

}
