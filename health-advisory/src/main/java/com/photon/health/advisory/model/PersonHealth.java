package com.photon.health.advisory.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author kishan.gupta
 *
 */
public class PersonHealth {
	@JsonProperty("Gender")
	private String gender;

	@JsonProperty("HeightCm")
	private float height;

	@JsonProperty("WeightKg")
	private float weight;

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "PersonHealth [gender=" + gender + ", height=" + height + ", weight=" + weight + "]";
	}
}
