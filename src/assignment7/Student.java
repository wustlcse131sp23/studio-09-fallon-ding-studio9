package assignment7;

//TODO: Copy a working Student class from Assignment 7 over this file.
public class Student {
	private String firstName;
	private String lastName;
	private int id;
	private int attemptedCredits;
	private int passingCredits;
	private double qualityPoints;
	private double balance;
	private double GPA;
	
	public Student(String firstName, String lastName, int id) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.id = id;
	}
	
	public void setFirst(String fN) {
		this.firstName = fN;
	}
	
	public void setLast(String lN) {
		this.lastName = lN;
	}
	
	public String getFullName() {
		return this.firstName + " " + this.lastName;
	}
	
	public int getId() {
		return this.id;
	}
	
	public int getTotalAttemptedCredits() {
		return this.attemptedCredits;
	}
	
	public int getTotalPassingCredits() {
		return this.passingCredits;
	}
	
	public double calculateGradePointAverage() {
		return this.qualityPoints / this.attemptedCredits;
	}
	
	public void submitGrade(double grade, int credits) {
		qualityPoints += grade * credits;
		attemptedCredits += credits;
		if (grade >= 1.7) {
			passingCredits += credits;
		}
	}
	
	public String getClassStanding() {
		if (this.passingCredits < 30) {
			return "First Year";
		}
		else if (this.passingCredits >= 30 && this.passingCredits < 60) {
			return "Sophomore";
		}
		else if (this.passingCredits >= 60 && this.passingCredits < 90) {
			return "Junior";
		}
		else
			return "Senior";
	}
	
	public boolean isEligibleForPhiBetaKappa() {
		if (this.attemptedCredits >= 98 && this.calculateGradePointAverage() >= 3.6) {
			return true;
		}
		else if (this.attemptedCredits >= 75 && this.calculateGradePointAverage() >= 3.8) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void depositBearBucks(double amount) {
		balance += amount;
	}
	
	public void deductBearBucks(double amount) {
		balance -= amount;
	}
	
	public double getBearBucksBalance() {
		return this.balance;
	}
	
	public double cashOutBearBucks() {
		double prevBalance = this.balance;
		
		if (this.balance > 10) {
			this.balance = 0;
			return prevBalance - 10;
		}
		else {
			this.balance = 0;
			return 0;
		}
	}
	
	public Student createLegacy(String firstName, Student otherParent, boolean isHyphenated, int id) {
		String childLastName = this.lastName;
		
		if (isHyphenated) {
			childLastName = this.lastName + "-" + otherParent.lastName;
		}
		
		Student child = new Student(firstName, childLastName, id);
		child.balance = this.cashOutBearBucks() + otherParent.cashOutBearBucks();

		return child;
	}
	
	public String toString() {
		return this.getFullName() + ", " + this.id;
	}
}
