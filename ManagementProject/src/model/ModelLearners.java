package model;

public class ModelLearners {
	private String CodeLerner;

	public String getCodeLerner() {
		return CodeLerner;
	}

	public void setCodeLerner(String codeLerner) {
		CodeLerner = codeLerner;
	}

	public ModelLearners(String codeLerner) {
		CodeLerner = codeLerner;
	}
	
	public ModelLearners() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return CodeLerner;
	}
	
}
