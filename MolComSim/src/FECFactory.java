
public class FECFactory {

	static public ForwardErrorCorrection create(FECMethodType method, double rate, int numRequiredPackets) {
		switch (method) {
		case PARITYCHECK:
			return new ParityCheck(rate, numRequiredPackets);
			
		case NONE:
			return null;
		}
		return null;
	}

}
