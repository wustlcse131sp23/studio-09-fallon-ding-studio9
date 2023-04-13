package studio9;

import java.util.HashMap;
import java.util.Map;

import assignment7.Student;

public class UniversityDatabase {
	private final Map<String, Student> studentMap;

	public UniversityDatabase() {
		this.studentMap = new HashMap<String, Student>();
	}
	
	public void addStudent(String accountName, Student student) {
		this.studentMap.put(accountName, student);
	}

	public int getStudentCount() {
		return this.studentMap.size();
	}

	public String lookupFullName(String accountName) {
		Student person = studentMap.get(accountName);
		if (person == null) {
			return null;
		}
		return person.getFullName();
	}

	public double getTotalBearBucks() {
		double totalBearBucks = 0.0;
		for (String currentPerson : studentMap.keySet()) {
			Student person = studentMap.get(currentPerson);
			totalBearBucks += person.getBearBucksBalance();
		}
		return totalBearBucks;
	}
}
