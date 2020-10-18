package com.ewallet.repository;

import static org.junit.Assert.*;

import java.util.Optional;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.ewallet.entity.User;
import com.ewallet.repository.UserRepository;




@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
@Component
public class UserRepositoryTest {
	
	private static final String EMAIL = "email@teste.com";
	
	@Autowired
	UserRepository repository; 
	
    @org.junit.Before
    @Test
	public void setUp(){ 
		User u = new User();
		u.setName("Set up user");
		u.setPassword("Senha123");
		u.setEmail(EMAIL);
		
		repository.save(u);
	}
    
    @After
    public void tearDown() { 
    	repository.deleteAll();   	
    }
		
	@Test
	public void testSave() { 
		User u = new User();
		u.setName("Teste");
		u.setPassword("123456");
		u.setEmail("teste@teste.com");
		
		User response = repository.save(u);
		
		assertNotNull(response);
	}
	
	@Test
	public void findByEmailTest() { 
		Optional<User> response = repository.findByEmailEquals(EMAIL);
		
		assertTrue(response.isPresent());
		assertEquals(response.get().getEmail(), EMAIL);
	}
}
