package com.acme.todolist.adapters.rest_api;

import java.util.List;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.acme.todolist.application.port.in.AddTodoItem;
import com.acme.todolist.application.port.in.GetTodoItems;
import com.acme.todolist.domain.TodoItem;

/**
 * Le controlleur Spring MVC qui expose les endpoints REST
 * 
 * @author bflorat
 *
 */
@RestController
public class TodoListController {
	
	private GetTodoItems getTodoItemsQuery;
	private AddTodoItem addTodoItemsQuery;
	
	@Inject
	public TodoListController(GetTodoItems getTodoItemsQuery ) {
		this.addTodoItemsQuery = addTodoItemsQuery;
		this.getTodoItemsQuery = getTodoItemsQuery;
	}
	
	@GetMapping("/todos")
	public List<TodoItem> getAllTodoItems() {
		return this.getTodoItemsQuery.getAllTodoItems();
	}
	
	
	@GetMapping("/todos")
	public void ajouterItem(@RequestBody TodoItem item) {
		this.addTodoItemsQuery.addTodoItem(item);
	}
	
	
}
