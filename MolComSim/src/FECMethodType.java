
public enum FECMethodType {
	
	PARITYCHECK,
	NONE;
	
	public static FECMethodType getFECMethodType(String stringRep) {
		if(stringRep.equals("PARITYCHECK")) {
			return PARITYCHECK;
		} else if(stringRep.equals("NONE")) {
			return NONE;
		} else {
			throw new IllegalArgumentException("Invalid argument: " + stringRep + 
					" to FECType.getFECType");
		}
	}
}
