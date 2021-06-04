package com.photon.health.advisory.endpoint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.photon.health.advisory.model.HealthReport;
import com.photon.health.advisory.model.PersonHealth;
import com.photon.health.advisory.service.BMIcalculatorService;

/**
 * @author kishan.gupta
 *
 */
@RestController
@RequestMapping("/health")
public class BMICalculatorEndpoint {

	@Autowired
	private BMIcalculatorService bmiService;

	/**
	 * Health API endpoint to get the health report on passed list of PersonHealth
	 * 
	 * @param list of PersonHealth
	 * @return health reports classification having BMI, BMI and risk category for
	 *         provided data.
	 */
	@PostMapping("advisory")
	public List<HealthReport> getHealthAdvisory(@RequestBody List<PersonHealth> details) {
		System.out.println(details);
		List<HealthReport> healthReports = bmiService.processForBMI(details);
		System.out.println("Health Report :: " + healthReports);
		System.out.println("Overweight count :: " + bmiService.getOverweightCount(healthReports));
		return healthReports;
	}
}
