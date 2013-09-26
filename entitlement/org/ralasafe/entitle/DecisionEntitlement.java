/**
 * Copyright (c) 2004-2011 Wang Jinbao(Julian Wong), http://www.ralasafe.com
 * Licensed under the MIT license: http://www.opensource.org/licenses/mit-license.php
 */
package org.ralasafe.entitle;

/**
 *
 * A decision rule. A (decision) privilege can contain many rules.
 * A rule descibes privilege/userCategory/businessData/ relationship.
 * 表示一个决策规则，对应数据表${appName}_decision_entitlement。一个决策权限可以包含若干条决策规则。 一条决策规含有 权限/用户分类/业务数据/权限关系 的信息
 * <p></p>
 * 一条决策规则能通过(privilegedId,userCategoryId,businessDataId)唯一确定
 * Unique index(privilegeId, userCategoryId, businessDataId)
 * .
 * For a certain privilege, a certain usercategory may be refed by many businessdata.
 *
 */
public class DecisionEntitlement {
	public static final String DENY="deny";
	public static final String PERMIT="permit";
	/**
	 * privilege id, it must be leaf node
	 */
	private int privilegeId;
	private int userCategoryId;
	private int businessDataId;
	private int id;
	private String effect;
	private String denyReason;
	private UserCategory userCategory;
	private BusinessData businessData;
	public int getPrivilegeId() {
		return privilegeId;
	}
	public void setPrivilegeId( int privilegeId ) {
		this.privilegeId=privilegeId;
	}
	public int getUserCategoryId() {
		return userCategoryId;
	}
	public void setUserCategoryId( int userCategoryId ) {
		this.userCategoryId=userCategoryId;
	}
	public int getBusinessDataId() {
		return businessDataId;
	}
	public void setBusinessDataId( int businessDataId ) {
		this.businessDataId=businessDataId;
	}
	public int getId() {
		return id;
	}
	public void setId( int id ) {
		this.id=id;
	}
	public String getEffect() {
		return effect;
	}
	public void setEffect( String effect ) {
		this.effect=effect;
	}
	public String getDenyReason() {
		return denyReason;
	}
	public void setDenyReason( String denyReason ) {
		this.denyReason=denyReason;
	}
	public UserCategory getUserCategory() {
		return userCategory;
	}
	public void setUserCategory( UserCategory userCategory ) {
		this.userCategory=userCategory;
	}
	public BusinessData getBusinessData() {
		return businessData;
	}
	public void setBusinessData( BusinessData businessData ) {
		this.businessData=businessData;
	}
}
