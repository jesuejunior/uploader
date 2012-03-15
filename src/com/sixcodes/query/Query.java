package com.sixcodes.query;

public class Query {

	private StringBuffer query;
	
	public Query() {
		this.query = new StringBuffer();
	}
	
	public Query select(String ... campos) {
		this.query.append("SELECT ");
		
		if (campos.length > 0){
			for (int i = 0; i < campos.length - 1; i++){
				String c = campos[i];
				this.query.append(c);
				this.query.append(", ");
			}
			this.query.append(campos[campos.length - 1]);
		}
		return this;
	}

	public String toSql() {
		return this.query.toString();
	}

	public Query from(String tabela) {
		this.query.append(" FROM ");
		this.query.append(tabela);
		this.query.append(" ");
		return this;
	}

	public Query where(String where) {
		this.query.append(" WHERE ");
		this.query.append(where);
		return this;
	}

	public Query and(String and) {
		this.query.append(" AND ");
		this.query.append(and);
		this.query.append(" ");
		return this;
	}

}
