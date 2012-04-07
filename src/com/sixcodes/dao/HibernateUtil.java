package com.sixcodes.dao;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;

public class HibernateUtil {

	private static SessionFactory sessionFactory;
	private static Session session;

	public static void salvarOuAtualizar(Object objeto) {

		abreConexaoComBanco();
		session.saveOrUpdate(objeto);
		fechaConexaoComBanco();
	}

	public static void deletar(Object objeto) {

		abreConexaoComBanco();
		session.delete(objeto);
		fechaConexaoComBanco();
	}

	@SuppressWarnings("unchecked")
	public static <E extends Object> List<E> listarTodos(Object classe) {

		abreConexaoComBanco();
		Criteria crit = session.createCriteria(classe.getClass());
		return crit.list();
	}

	@SuppressWarnings("unchecked")
	public static <E extends Object> List<E> listarComRestricoes(Object classe, Criterion criterion) {

		abreConexaoComBanco();

		return session.createCriteria(classe.getClass()).add(criterion).list();
	}

	@SuppressWarnings("deprecation")
	private static void abreConexaoComBanco() {
		
		if(sessionFactory == null){
						
			sessionFactory = new Configuration().configure().buildSessionFactory();
		}

		session = sessionFactory.openSession();
		session.beginTransaction();
	}

	private static void fechaConexaoComBanco() {

		session.getTransaction().commit();
		session.close();
	}

}
