package com.sixcodes.query;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class QueryTest {
	
	
	private Query q;


	@Before
	public void setUp(){
		q = new Query();
	}

	@Test
	public void selectComCampos() {
		Query select = q.select("a", "b", "c");
		assertNotNull(select);
		assertTrue(select == q);
		assertEquals("SELECT a, b, c", select.toSql());
	}

	@Test
	public void selectSemCampos() {
		Query select = q.select();
		assertNotNull(select);
		assertTrue(select == q);
		assertEquals("SELECT ", select.toSql());
	}
	
	
	@Test
	public void from(){
		q.from("tabela");
		assertEquals(" FROM tabela ", q.toSql());
	}
	
	@Test
	public void selectFrom(){
		q.select("id", "nome", "tamanho").from("arquivo");
		assertEquals("SELECT id, nome, tamanho FROM arquivo ", q.toSql());
	}
	
	@Test
	public void where(){
		q.where("id = 10");
		assertEquals(" WHERE id = 10", q.toSql());
	}

	@Test
	public void whereCompleto(){
		q.select("nome").from("arquivo").where("id = 10");
		assertEquals("SELECT nome FROM arquivo  WHERE id = 10", q.toSql());
	}
	
	@Test
	public void and(){
		q.and("tamanho > 10");
		assertEquals(" AND tamanho > 10 ", q.toSql());
	}

	@Test
	public void andDuplo(){
		q.and("tamanho > 10").and("id < 10");
		assertEquals(" AND tamanho > 10  AND id < 10 ", q.toSql());
	}

	@Test
	public void andCompleto(){
		q.select("nome", "tamanho").from("arquivo").where("tamanho > 10").and("id > 10").and("id < 20");
		assertEquals("SELECT nome, tamanho FROM arquivo  WHERE tamanho > 10 AND id > 10  AND id < 20 ", q.toSql());
	}
	
	

}
