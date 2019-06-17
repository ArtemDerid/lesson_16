package ua.lviv.lgs;

import java.io.Serializable;

public class Pet extends Animal implements Serializable{
	
	public String type;
	public int age;
	private String name;
	private double weight;
	
	public Pet() {}
	
	public Pet(String type, int age, String name, double weight) {
		super();
		this.type = type;
		this.age = age;
		this.name = name;
		this.weight = weight;
	}

	public Pet(String type, int age) {
		super();
		this.type = type;
		this.age = age;
	}
	
	public void setTypeAndAge(String type, int age) {
		this.type = type;
		this.age = age;
	}
	
	public void newName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		long temp;
		temp = Double.doubleToLongBits(weight);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pet other = (Pet) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (Double.doubleToLongBits(weight) != Double.doubleToLongBits(other.weight))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Pet [type=" + type + ", age=" + age + ", name=" + name + ", weight=" + weight + "]";
	}

}
