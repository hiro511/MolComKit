// NullFEC class is generated when any FEC methods are specified: NONE.
// just assemble information molecules as packets to a message
public class NullFEC extends ForwardErrorCorrection{

	public NullFEC(FECParams params, int numRequiredPackets) {
		super(params, numRequiredPackets);
	}

	@Override
	boolean canDecode() {
		return numRecievedPackets >= numRequiredPackets ? true : false;
	}

	@Override
	MoleculeParams encode(MoleculeParams molParams) {
		return molParams;
	}

	@Override
	void recieve(Molecule m) {
		
	}
}
