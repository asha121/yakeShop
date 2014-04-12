package com.xebia.entity;

public class Labyak {

	private String name;
	private float age;
	private String sex;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getAge() {
		return age;
	}

	public void setAge(float age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Override
	public String toString() {
		StringBuilder message = new StringBuilder(name);
		message.append(" ");
		if (age > 10) {
			message.append(10);
			message.append("Died");
		} else {
			message.append(age);
			message.append(" years old");

		}

		return message.toString();
	}

}
