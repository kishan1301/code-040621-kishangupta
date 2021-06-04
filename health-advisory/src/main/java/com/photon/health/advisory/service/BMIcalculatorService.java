package com.photon.health.advisory.service;

import java.util.List;

import com.photon.health.advisory.model.HealthReport;
import com.photon.health.advisory.model.PersonHealth;

/**
 * @author kishan.gupta
 *
 */
public interface BMIcalculatorService {

	/**
	 * @param height of person in CM
	 * @param weight of person in KG
	 * @return BMI value
	 */
	public abstract float calculateBMI(float height, float weight);

	/**
	 * @param list of PersonHealth to process the BMI and assign the risk categories
	 *             as per BMI value.
	 * @return HealthReport list for provided data having BMI, BMI and risk category
	 *         classification.
	 */
	public abstract List<HealthReport> processForBMI(List<PersonHealth> healthList);

	/**
	 * @param HealthReport object and calculates the risk category of the person.
	 */
	public abstract void updateOtherHealthFacts(HealthReport report);

	/**
	 * @param healthReports, i.e., Health report of a group.
	 * @return count of persons having BMI category as Overweight.
	 */
	public abstract long getOverweightCount(List<HealthReport> healthReports);

	/**
	 * @param healthReports, i.e., Health report of a group.
	 * @return count of persons having serious health issue, i.e., having higher BMI
	 *         category Overweight and above.
	 */
	public abstract long personCountHavingSeriousHealthIssues(List<HealthReport> healthReports);

	/**
	 * @param healthReports, i.e., Health report of a group.
	 * @return count of Malnutrition person in that group.
	 */
	public abstract long malnutritionPersonCount(List<HealthReport> healthReports);
}
