package com.junior.purchaseworkflow.model;

public class Filter
{
	private String requesterName;
	private String productDescription;
	private boolean approved;

	public String getRequesterName()
	{
		return requesterName;
	}

	public void setRequesterName(String requesterName)
	{
		this.requesterName = requesterName;
	}

	public String getProductDescription()
	{
		return productDescription;
	}

	public void setProductDescription(String productDescription)
	{
		this.productDescription = productDescription;
	}

	public boolean isApproved()
	{
		return approved;
	}

	public void setApproved(boolean approved)
	{
		this.approved = approved;
	}
}
