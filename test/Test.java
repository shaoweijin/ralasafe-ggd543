import org.ralasafe.demo.LoanMoney;

import java.lang.reflect.InvocationTargetException;


public class Test {
	/**
	 * @param args
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 */
	public static void main( String[] args ) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		LoanMoney hintObj=new LoanMoney();
		hintObj.setMoney( 23 );
		Class clazz=hintObj.getClass(); 
		String key="money";
		
		java.lang.reflect.Method getter=org.ralasafe.util.Util.getJavabeanGetMethod( clazz.getName(), key ); 
		Object loanMoney=getter.invoke( hintObj, new Object[] {} );
		System.out.println( loanMoney );
	}
}
