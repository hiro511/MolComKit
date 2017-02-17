
public abstract class ForwardErrorCorrection {
	protected int numRequiredPackets;
	protected int numRecievedPackets = 0;
	
	public ForwardErrorCorrection(FECParams params, int numRequiredPackets) {
		this.numRequiredPackets = numRequiredPackets;
	}
	
	// return if it is possible to decode.
	abstract boolean canDecode();
	// encode an information molecule based on moleculeParams
	// return modified moleculeParams
	abstract MoleculeParams encode(MoleculeParams molParams);
	// implement a process when an information molecule received
	abstract void recieve(Molecule m);
	
	final public void add(Molecule m) {
		numRecievedPackets++;
		recieve(m);
	}
	
	public int getNumRecievedPackets() {
		return numRecievedPackets;
	}
}
