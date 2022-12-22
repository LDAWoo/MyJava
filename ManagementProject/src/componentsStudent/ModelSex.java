package componentsStudent;

public class ModelSex {
	private boolean sex;

	public boolean isSex() {
		return sex;
	}

	public void setSex(boolean sex) {
		this.sex = sex;
	}


	public ModelSex(boolean sex) {
		super();
		this.sex = sex;
	}

	public ModelSex() {
		super();
	}
	
	@Override
	public String toString() {
		if(sex) {
			return "Nam";
		}
		return "Nữ";
	}
}
