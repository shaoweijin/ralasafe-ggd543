package org.ralasafe.entitle;

import junit.framework.TestCase;

import org.ralasafe.StartService;
import org.ralasafe.user.User;

public class QueryManagerImplTest extends TestCase {
	protected void setUp() throws Exception {
		StartService.startup();
	}
	
	public void testGetUserRole() {
		QueryManagerImpl mng=new QueryManagerImpl("ralasafe");
		Query query=mng.getQuery( -10 );
		User user=new User();
		user.setId( new Integer(2) );
		QueryResult result=query.execute( user, null );
		System.out.println( result.getTotalCount() );
		System.out.println( result.getData() );
	}
}
