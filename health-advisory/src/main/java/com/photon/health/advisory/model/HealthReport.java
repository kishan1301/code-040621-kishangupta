package com.photon.health.advisory.model;

/**
 * @author kishan.gupta
 *
 */
public class HealthReport {
	private float bmi;
	private String bmiCategory;
	private String healthRiskCategory;

	public float getBmi() {
		return bmi;
	}

	public String getBmiCategory() {
		return bmiCategory;
	}

	public void setBmiCategory(String bmiCategory) {
		this.bmiCategory = bmiCategory;
	}

	public String getHealthRiskCategory() {
		return healthRiskCategory;
	}

	public void setHealthRiskCategory(String healthRiskCategory) {
		this.healthRiskCategory = healthRiskCategory;
	}

	public void setBmi(float bmi) {
		this.bmi = bmi;
	}

	@Override
	public String toString() {
		return "HealthReport [bmi=" + bmi + ", bmiCategory=" + bmiCategory + ", healthRiskCategory="
				+ healthRiskCategory + "]";
	}
}
