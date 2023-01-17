package lesson04;

public class Worker {
	private final String name;
	private final String surname;
	private final Sex sex;
	private final int age;
	private final String professional;
	private final String workTown;

	public Worker(String name, String surname, Sex sex, int age, String professional, String workTown) {
		this.name = name;
		this.surname = surname;
		this.sex = sex;
		this.age = age;
		this.professional = professional;
		this.workTown = workTown;
	}

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	public Sex getSex() {
		return sex;
	}

	public int getAge() {
		return age;
	}

	public String getProfessional() {
		return professional;
	}

	public String getWorkTown() {
		return workTown;
	}

	@Override
	public String toString() {
		return "Worker{" +
				"name='" + name + '\'' +
				", surname='" + surname + '\'' +
				", sex=" + sex +
				", age=" + age +
				", professional='" + professional + '\'' +
				", workTown='" + workTown + '\'' +
				'}';
	}
}
