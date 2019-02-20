package com.ritu.cms.base.where;

public enum SqlEnum {

	ALL("all", " where 1 = 1 "),
	LNG("lng", "st_x(ST_Centroid(geom))"), 
	LAT("lat", "st_y(ST_Centroid(geom))"), 
	LOCATION("location", "concat(st_x(ST_Centroid(geom)) ,',', st_y(ST_Centroid(geom)))"), 
	POLY_EDGE("poly_edge", "replace(replace(replace(replace(st_astext(geom),',',';'),' ',','),'MULTIPOLYGON(((',''),')))','')"), 
	LINE_EDGE("line_edge", "replace(replace(replace(replace(st_astext(geom),',',';'),' ',','),'MULTILINESTRING((',''),'))','')");
	
	private String columType;
	private String sql;

	private SqlEnum(String columType, String sql) {
		this.columType = columType;
		this.sql = sql;
	}

	public String getColumType() {
		return columType;
	}

	public void setColumType(String columType) {
		this.columType = columType;
	}

	public String getSql() {
		return sql;
	}

	public void setSql(String sql) {
		this.sql = sql;
	}

}
