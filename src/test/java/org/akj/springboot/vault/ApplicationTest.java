package org.akj.springboot.vault;

import javax.sql.DataSource;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = { Application.class })
class ApplicationTest {

	@Autowired
	private Environment env;
	
	@Autowired
	private DataSource dataSource;

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void test() {
		String pwd = env.getProperty("password");
		String username = env.getProperty("spring.datasource.username");
		
		assertNotNull(pwd);
		assertEquals(username, "root");
		assertNotNull(dataSource);
	}

}
