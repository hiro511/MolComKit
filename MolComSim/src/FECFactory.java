
public class FECFactory {

	static public ForwardErrorCorrection create(FECParams params, int numRequiredPackets) {
		switch (params.getFECMethod()) {
		case PARITYCHECK:
			return new ParityCheck(params, numRequiredPackets);
		case NONE:
			return new NullFEC(params, numRequiredPackets);
		default:
			break;
		}
		return null;
	}

}
