package com.untitled.dataaccess.entity.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.untitled.dataaccess.entity.test.todo.Todo;
import com.untitled.dataaccess.entity.test.todo.TodoRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/app-context.xml")
@ActiveProfiles("application")
public class SpringDataTests {
	
	@Autowired
	private TodoRepository todoRepo;

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
		todoRepo.deleteAll();
	}

	@Test
	public void testCount() {
		assertEquals(0, todoRepo.count());
	}

	@Test
	public void testSave() {
		Todo todo = new Todo();
		todo.setTitle("Another todo");
		todoRepo.save(todo);
		assertEquals(1, todoRepo.count());
	}
	
	@Test
	public void testFindAll() {
		Todo todo = new Todo();
		todo.setTitle("Another todo");
		todoRepo.save(todo);
		assertEquals(1, todoRepo.count());
		Iterable<Todo> todos = todoRepo.findAll();
		assertNotNull(todos);
	}
	
	@Test
	public void testFindByTitle() {
		String title = "Another todo";
		Todo todo = new Todo();
		todo.setTitle(title);
		todoRepo.save(todo);
		assertEquals(1, todoRepo.count());
		List<Todo> results = todoRepo.findByTitle(title);
		assertNotNull(results);
		assertFalse(results.isEmpty());
	}
	
	@Test
	public void testFindByTitleAndDescription() {
		String title = "Another todo";
		String description = "This is the description!";
		
		Todo todo = new Todo();
		todo.setTitle(title);
		todo.setDescription(description);
		todoRepo.save(todo);
		
		Todo result = todoRepo.findByTitleAndDescription(title, description);
		System.err.println(result.getCreationTime());
		assertNotNull(result);
		assertEquals(title,result.getTitle());
		assertEquals(description,result.getDescription());
	}
	
	
	@Test
	public void testAuditingTime() {
		String title = "First todo";
		String description = "This is the description!";
		
		Todo todo = new Todo();
		todo.setTitle(title);
		todo.setDescription(description);
		Todo newTodo = todoRepo.save(todo);
		
		
		String title2 = "This should be a new title!";
		newTodo.setTitle(title2);
		todoRepo.save(newTodo);
		
		List<Todo> results = todoRepo.findByTitle(title2);
		Todo result = results.get(0);
		System.out.println(result.getCreationTime());
		System.out.println(result.getModificationTime());
		assertNotNull(result);
		//assertTrue(result.getModificationTime().after(result.getCreationTime()));
		assertEquals(title2,result.getTitle());
		assertEquals(description,result.getDescription());
	}
}
