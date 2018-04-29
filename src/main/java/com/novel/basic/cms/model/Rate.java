package com.novel.basic.cms.model;

import java.util.Date;

/**
 * @author dennis.sun
 * 利率model
 * */
public class Rate {

	private int id;

	/**
	 * 利率种类
	 */
	private String rateType;

	/**
	 * 利率期限年
	 */
	private String terminable;

	/**
	 * 年利率
	 */
	private String annualInterestRate;

	/**
	 * 创建人
	 */
	private String createdBy;

	/**
	 * 创建时间
	 */
	private Date createTime;

	/**
	 * 修改人
	 */
	private String  updateBy;

	/**
	 * 修改时间
	 */
	private Date updateTime;

	/**
	 * 是否删除
	 */
	private int isDeleted;


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRateType() {
		return rateType;
	}

	public void setRateType(String rateType) {
		this.rateType = rateType;
	}

	public String getTerminable() {
		return terminable;
	}

	public void setTerminable(String terminable) {
		this.terminable = terminable;
	}

	public String getAnnualInterestRate() {
		return annualInterestRate;
	}

	public void setAnnualInterestRate(String annualInterestRate) {
		this.annualInterestRate = annualInterestRate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public int getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(int isDeleted) {
		this.isDeleted = isDeleted;
	}
}