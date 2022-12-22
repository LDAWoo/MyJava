package componentsStudent;

public class ModelLearner {
	private String CodeLerner;

	public String getCodeLerner() {
		return CodeLerner;
	}

	public void setCodeLerner(String codeLerner) {
		CodeLerner = codeLerner;
	}

	public ModelLearner(String codeLerner) {
		CodeLerner = codeLerner;
	}
	
	public ModelLearner() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return CodeLerner;
	}
	
}
