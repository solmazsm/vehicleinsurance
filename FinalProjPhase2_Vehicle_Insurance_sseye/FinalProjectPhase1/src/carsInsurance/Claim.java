package carsInsurance;

public class Claim implements Photos {
	/*
	 * instance fields with appropriate data types
	 */
	private Policy policyNumber;
	private String ClaimId;
	private String claimDate;
	private boolean claimAirbag;
	/**
	 * @return the policyNumber
	 */
	public Policy getPolicyNumber() {
		return policyNumber;
	}

	/**
	 * @param policyNumber the policyNumber to set
	 */
	public void setPolicyNumber(Policy policyNumber) {
		this.policyNumber = policyNumber;
	}

	/**
	 * @return the claimId
	 */
	public String getClaimId() {
		return ClaimId;
	}

	/**
	 * @param claimId the claimId to set
	 */
	public void setClaimId(String claimId) {
		ClaimId = claimId;
	}

	/**
	 * @return the claimDate
	 */
	public String getClaimDate() {
		return claimDate;
	}

	/**
	 * @param claimDate the claimDate to set
	 */
	public void setClaimDate(String claimDate) {
		this.claimDate = claimDate;
	}

	/**
	 * @return the claimAirbag
	 */
	public boolean isClaimAirbag() {
		return claimAirbag;
	}

	/**
	 * @param claimAirbag the claimAirbag to set
	 */
	public void setClaimAirbag(boolean claimAirbag) {
		this.claimAirbag = claimAirbag;
	}

	/**
	 * @return the pointOfImpact
	 */
	public String getPointOfImpact() {
		return pointOfImpact;
	}

	/**
	 * @param pointOfImpact the pointOfImpact to set
	 */
	public void setPointOfImpact(String pointOfImpact) {
		this.pointOfImpact = pointOfImpact;
	}

	/**
	 * @return the fileAmount
	 */
	public double getFileAmount() {
		return fileAmount;
	}

	/**
	 * @param fileAmount the fileAmount to set
	 */
	public void setFileAmount(double fileAmount) {
		this.fileAmount = fileAmount;
	}

	

	/**
	 * @return the isConfirmed
	 */
	public boolean isConfirmed() {
		return isConfirmed;
	}

	/**
	 * @param isConfirmed the isConfirmed to set
	 */
	public void setConfirmed(boolean isConfirmed) {
		this.isConfirmed = isConfirmed;
	}

	private String pointOfImpact;
	private double fileAmount;
	//private Policy policyid;
    private boolean isConfirmed;
	public void addclaim() {
	}

	public void viewclaim() {
	}

	@Override
	public void addphoto() {
		// TODO Auto-generated method stub

	}

	@Override
	public void deletephoto() {
		// TODO Auto-generated method stub

	}

	public void updatephoto() {
	}
}