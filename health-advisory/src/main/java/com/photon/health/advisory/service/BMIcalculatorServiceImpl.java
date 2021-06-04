package com.photon.health.advisory.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.photon.health.advisory.model.HealthReport;
import com.photon.health.advisory.model.HealthRisksEnum;
import com.photon.health.advisory.model.PersonHealth;

/**
 * @author kishan.gupta
 *
 */
@Service
public class BMIcalculatorServiceImpl implements BMIcalculatorService {

	/**
	 * @param height of person in CM
	 * @param weight of person in KG
	 * @return BMI value
	 */
	@Override
	public float calculateBMI(float height, float weight) {
		return (float) (weight / Math.pow((height / 100), 2));
	}

	/**
	 * @param list of PersonHealth to process the BMI and assign the risk categories
	 *             as per BMI value.
	 * @return HealthReport list for provided data having BMI, BMI and risk category
	 *         classification.
	 */
	@Override
	public List<HealthReport> processForBMI(List<PersonHealth> healthList) {
		return healthList.stream().map(a -> {
			HealthReport report = new HealthReport();
			report.setBmi(this.calculateBMI(a.getHeight(), a.getWeight()));
			this.updateOtherHealthFacts(report);
			return report;
		}).collect(Collectors.toList());
	}

	/**
	 * @param HealthReport object and calculates the risk category of the person.
	 */
	@Override
	public void updateOtherHealthFacts(HealthReport report) {
		if (!HealthRisksEnum.MALNUTRITION_RISK.calculateHealthRiskBasisBMI(report.getBmi()).isBlank()) {
			report.setBmiCategory(HealthRisksEnum.MALNUTRITION_RISK.getBmiCategory());
			report.setHealthRiskCategory(HealthRisksEnum.MALNUTRITION_RISK.getRiskDescription());
		} else if (!HealthRisksEnum.LOW_RISK.calculateHealthRiskBasisBMI(report.getBmi()).isBlank()) {
			report.setHealthRiskCategory(HealthRisksEnum.LOW_RISK.getRiskDescription());
			report.setBmiCategory(HealthRisksEnum.LOW_RISK.getBmiCategory());
		} else if (!HealthRisksEnum.ENHANCED_RISK.calculateHealthRiskBasisBMI(report.getBmi()).isBlank()) {
			report.setHealthRiskCategory(HealthRisksEnum.ENHANCED_RISK.getRiskDescription());
			report.setBmiCategory(HealthRisksEnum.ENHANCED_RISK.getBmiCategory());
		} else if (!HealthRisksEnum.MEDIUM_RISK.calculateHealthRiskBasisBMI(report.getBmi()).isBlank()) {
			report.setHealthRiskCategory(HealthRisksEnum.MEDIUM_RISK.getRiskDescription());
			report.setBmiCategory(HealthRisksEnum.MEDIUM_RISK.getBmiCategory());
		} else if (!HealthRisksEnum.HIGH_RISK.calculateHealthRiskBasisBMI(report.getBmi()).isBlank()) {
			report.setHealthRiskCategory(HealthRisksEnum.HIGH_RISK.getRiskDescription());
			report.setBmiCategory(HealthRisksEnum.HIGH_RISK.getBmiCategory());
		} else {
			report.setHealthRiskCategory(HealthRisksEnum.VERY_HIGH_RISK.getRiskDescription());
			report.setBmiCategory(HealthRisksEnum.VERY_HIGH_RISK.getBmiCategory());
		}
	}

	/**
	 * @param healthReports, i.e., Health report of a group.
	 * @return count of persons having BMI category as Overweight.
	 */
	@Override
	public long getOverweightCount(List<HealthReport> riskReports) {
		System.out.println("Serious Health issue :: "
				+ riskReports.stream().filter(a -> a.getBmi() > HealthRisksEnum.ENHANCED_RISK.getLowerBound()).count());
		return riskReports.stream()
				.filter(a -> a.getBmiCategory().equals(HealthRisksEnum.ENHANCED_RISK.getBmiCategory())).count();

	}

	/**
	 * @param healthReports, i.e., Health report of a group.
	 * @return count of persons having serious health issue, i.e., having higher BMI
	 *         category Overweight and above.
	 */
	@Override
	public long personCountHavingSeriousHealthIssues(List<HealthReport> riskReports) {
		return riskReports.stream().filter(a -> a.getBmi() > HealthRisksEnum.ENHANCED_RISK.getLowerBound()).count();

	}

	/**
	 * @param healthReports, i.e., Health report of a group.
	 * @return count of Malnutrition person in that group.
	 */
	@Override
	public long malnutritionPersonCount(List<HealthReport> riskReports) {
		return riskReports.stream().filter(a -> a.getBmi() > HealthRisksEnum.ENHANCED_RISK.getLowerBound()).count();

	}

}
