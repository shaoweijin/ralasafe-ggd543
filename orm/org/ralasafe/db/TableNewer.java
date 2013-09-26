/**
 * Copyright (c) 2004-2011 Wang Jinbao(Julian Wong), http://www.ralasafe.com
 * Licensed under the MIT license: http://www.opensource.org/licenses/mit-license.php
 */
package org.ralasafe.db;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Helper class for define a table.
 * 定义数据表的工具类
 */
public class TableNewer {
    /**
     * 表名
     */
	private String tableName;
    /**
     * key/value=
     */
	private Map columnMap=new HashMap();

	private Map typeMap=new HashMap();

	private Map functionMap=new HashMap();

	private Map columnJavaBeanAttributeClassMap;
    /**
     * 每列映射的类名
     */
	private String[] columnJavaBeanAttributeClazz;
    /**
     * 数据表的列名集
     */
	private String[] columnNames;
    /**
     * 标识一条记录的列名集
     */
	private String[] idColumnNames;
    /**
     * 唯一确定一条记录的列名集
     */
	private String[] uniqueColumnNames;
    /**
     * 数据表的映射类
     */
	private String mappingClass;

	private int id;

	public String[] getColumnJavaBeanAttributeClazz() {
		return columnJavaBeanAttributeClazz;
	}

	public void setColumnJavaBeanAttributeClazz(
			String[] columnJavaBeanAttributeClazz ) {
		this.columnJavaBeanAttributeClazz=columnJavaBeanAttributeClazz;
		if( columnNames!=null ) {
			columnJavaBeanAttributeClassMap=new HashMap();
			for( int i=0; i<columnJavaBeanAttributeClazz.length; i++ ) {
				String attrClazz=columnJavaBeanAttributeClazz[i];
				columnJavaBeanAttributeClassMap.put( columnNames[i], attrClazz );
			}
		}
	}

	public void put( String columnName, ColumnAdapter adapter ) {
		columnMap.put( columnName, adapter );
	}
	
	public void put( String columnName, Type type ) {
		typeMap.put( columnName, type );
	}
	
	public void put( String columnName, String function ) {
		functionMap.put( columnName, function );
	}
	
	public String[] getColumnNames() {
		return columnNames;
	}

	public void setColumnNames( String[] columnNames ) {
		this.columnNames=columnNames;
		if( columnJavaBeanAttributeClazz!=null ) {
			columnJavaBeanAttributeClassMap=new HashMap();
			for( int i=0; i<columnJavaBeanAttributeClazz.length; i++ ) {
				String attrClazz=columnJavaBeanAttributeClazz[i];
				columnJavaBeanAttributeClassMap.put( columnNames[i], attrClazz );
			}
		}
	}

	public int getId() {
		return id;
	}

	public void setId( int id ) {
		this.id=id;
	}

	public String[] getIdColumnNames() {
		return idColumnNames;
	}

	public void setIdColumnNames( String[] idColumnNames ) {
		this.idColumnNames=idColumnNames;
	}

	public String[] getUniqueColumnNames() {
		return uniqueColumnNames;
	}

	public void setUniqueColumnNames( String[] uniqueColumnNames ) {
		this.uniqueColumnNames=uniqueColumnNames;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName( String tableName ) {
		this.tableName=tableName.toLowerCase();
	}
	
	public void setMappingClass( String mappingClass ) {
		this.mappingClass=mappingClass;
	}
	
	public String getMappingClass() {
		return this.mappingClass;
	}

	public Table getTable() {
		Table table=new Table();
		table.setId( id );
		table.setColumnNames( columnNames );
		Column[] cols=getColumnByName( columnNames );
		table.setColumns( cols );
		String[] exceptIdColumnNames=getExceptIdColumnNames();
		table.setExceptIdColumnNames( exceptIdColumnNames );
		table.setExceptIdColumns( getColumnByName( exceptIdColumnNames ) );
		table.setIdColumnNames( idColumnNames );
		table.setIdColumns( getColumnByName( idColumnNames ) );
		table.setName( tableName );
		table.setUniqueColumnNames( uniqueColumnNames );
		table.setUniqueColumns( getColumnByName( uniqueColumnNames ) );
		table.setMappingClass(mappingClass);
		return table;
	}

	private String[] getExceptIdColumnNames() {
		Set set=new HashSet();
		if( idColumnNames!=null ) {
			for( int i=0; i<idColumnNames.length; i++ ) {
				set.add( idColumnNames[i] );
			}
		}
		String[] names=new String[columnNames.length-set.size()];
		int addIndex=0;
		for( int i=0; i<columnNames.length; i++ ) {
			String name=columnNames[i];
			if( !set.contains( name ) ) {
				names[addIndex]=name;
				addIndex++;
			}
		}
		
		return names;
	}

    /**
     * 把一系列的列名转换成{@link Column}对象
     *
     * @param columnNames
     * @return
     */
	public Column[] getColumnByName( String[] columnNames ) {
		if( columnNames==null ) 
			return null;
		
		Column[] cols=new Column[columnNames.length];
		for( int i=0; i<cols.length; i++ ) {
			Column column=new Column();
			String name=columnNames[i];
			column.setName( name );
			ColumnAdapter adapter=(ColumnAdapter) columnMap.get( name );
			
			//if no adapter, create one
			if( adapter==null ) {
				if( MapStorgeObject.class.getName().equals( mappingClass ) ) {
					adapter=new MapStorgeColumnAdapter( name );
				} else {
					// javabean
					String attrClass=(String) columnJavaBeanAttributeClassMap.get( name );
					if( attrClass==null ) {
						attrClass="java.lang.Object";
					}
					adapter=new JavaBeanColumnAdapter( name, attrClass );
				}
				
				columnMap.put( name, adapter );
			}
			
			column.setAdapter( adapter );
			column.setType( (Type) typeMap.get( name ) );
			column.setFunction((String)functionMap.get( name ));
			cols[i]=column;
		}
		return cols;
	}
}
