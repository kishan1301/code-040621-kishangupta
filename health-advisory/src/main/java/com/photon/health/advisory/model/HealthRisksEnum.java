package com.photon.health.advisory.model;

/**
 * @author kishan.gupta
 *
 */
public enum HealthRisksEnum {
	MALNUTRITION_RISK(0, 18.4, "Underweight", "Malnutrition risk"), LOW_RISK(18.5, 24.9, "Normal weight", "Low risk"),
	ENHANCED_RISK(25.0, 29.9, "Overweight", "Enhanced risk"),
	MEDIUM_RISK(30.0, 34.9, "Moderately obese", "Medium risk"), HIGH_RISK(35, 39.9, "Severely obese", "High risk"),
	VERY_HIGH_RISK(40.0, 100.0, "Very severely obese", "Very high risk");

	private static final String EMPTY_STRING = "";

	HealthRisksEnum(double lowerBound, double upperBound, String bmiCategory, String riskDescription) {
		this.lowerBound = lowerBound;
		this.upperBound = upperBound;
		this.bmiCategory = bmiCategory;
		this.riskDescription = riskDescription;
	}

	private double lowerBound;
	private double upperBound;
	private String bmiCategory;
	private String riskDescription;

	public String getBmiCategory() {
		return bmiCategory;
	}

	public void setBmiCategory(String bmiCategory) {
		this.bmiCategory = bmiCategory;
	}

	public double getLowerBound() {
		return lowerBound;
	}

	public void setLowerBound(double lowerBound) {
		this.lowerBound = lowerBound;
	}

	public double getUpperBound() {
		return upperBound;
	}

	public void setUpperBound(double upperBound) {
		this.upperBound = upperBound;
	}

	public String getRiskDescription() {
		return riskDescription;
	}

	public void setRiskDescription(String riskDescription) {
		this.riskDescription = riskDescription;
	}

	public String calculateHealthRiskBasisBMI(float bmi) {
		if (lowerBound <= bmi && bmi <= upperBound) {
			return this.riskDescription;
		}
		return EMPTY_STRING;
	}
}
