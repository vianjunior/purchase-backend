package com.junior.purchaseworkflow.model;

import javax.persistence.*;

@Entity
@Table(name="Approval")
public class Approval
{
	private long approvalId;
	private boolean approved;
	private String obs;

	public Approval()
	{
	}

	public Approval(long approvalId, boolean approved, String obs)
	{
		this.approvalId = approvalId;
		this.approved = approved;
		this.obs = obs;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="approvalId")
	public long getApprovalId()
	{
		return approvalId;
	}

	public void setApprovalId(long approvalId)
	{
		this.approvalId = approvalId;
	}

	@Column(name="isApproved")
	public boolean isApproved()
	{
		return approved;
	}

	public void setApproved(boolean approved)
	{
		this.approved = approved;
	}

	@Column(name="obs")
	public String getObs()
	{
		return obs;
	}

	public void setObs(String obs)
	{
		this.obs = obs;
	}
}
