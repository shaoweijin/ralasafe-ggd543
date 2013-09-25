package org.ralasafe.db;

import junit.framework.TestCase;
import org.ralasafe.StartService;

import java.util.HashSet;
import java.util.Set;

public class DBViewTest extends TestCase {
	public void setUp() throws Exception {
		StartService.startup();
	}
	
	public void testGetTables() {
		String[] tableNames=DBView.getTableNames( "app", "zh-mydemo" );
		TestCase.assertEquals( 5, tableNames.length );
		
		Set set=new HashSet();
		for( int i=0; i<tableNames.length; i++ ) {
			String string=tableNames[i];
			set.add( string );
		}
		
		TestCase.assertTrue( set.contains( "company" ) );
		TestCase.assertTrue( set.contains( "demouser" ) );
		TestCase.assertTrue( set.contains( "department" ) );
		TestCase.assertTrue( set.contains( "loan_money" ) );
		TestCase.assertTrue( set.contains( "ralasafe_sequence" ) );
	}
	
	public void testGetTableView() {
		DBView.getTables( "app", "zh-mydemo" );
		TableView table=DBView.getTable( "app", "company" );
		System.out.println(table);
		
	}
}
