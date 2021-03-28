package com.acme.todolist;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.acme.todolist.domain.TodoItem;

class TodolistApplicationTests {

	@Test
	void contextLoads() {
	}
	/**
	 * RG 1 : si l'item a plus de 24h, ajouter dans le contenu une note "[LATE!]"*/

	@Test
	void testRPD1LateOK() { 
		TodoItem ti = new TodoItem("1", Instant.now().minus(25, ChronoUnit.HOURS), "desc item + 24h"); 
		// RG 1 : si l'item a plus de 24h, le contenu de sa note contient "[LATE!]"
		assertTrue(ti.finalContent().contains("LATE"));
		
	}

	@Test
	void testRPD1LateNOK() { 
		TodoItem ti = new TodoItem("1", Instant.now().plus(1, ChronoUnit.HOURS), "desc item - 24h"); 
		// RG 1 : si l'item a moins de 24h, le contenu de sa note ne contient pas "[LATE!]"
		assertFalse(ti.finalContent().contains("LATE"));
		
	}
	
	@Test
	void testRPD1LateNOKDans1H() { 
		TodoItem ti = new TodoItem("1", Instant.now().plus(1, ChronoUnit.HOURS), "desc item dans 1h"); 
		// RG 1 : si l'item a 24h, le contenu de sa note ne contient pas "[LATE!]"
		assertFalse(ti.finalContent().contains("LATE"));
		
	}
}
