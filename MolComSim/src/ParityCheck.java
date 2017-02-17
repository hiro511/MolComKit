import java.util.Arrays;

public class ParityCheck extends ForwardErrorCorrection{
	private double rate;
	private int numPacketsInBlock;
	private int numPackets;
	private boolean isReceived[] = null;

	public ParityCheck(FECParams params, int numRequiredPackets) {
		super(params, numRequiredPackets);
		this.rate = params.getFECRate();
		this.numPackets = (int)(numRequiredPackets * (rate + 1.0));
		this.numPacketsInBlock = (int) (1 / rate) + 1;
		this.isReceived = new boolean[this.numPackets];
		Arrays.fill(isReceived, false);
	}

	@Override
	public boolean canDecode() {
//		debug();
		if (numRecievedPackets < numRequiredPackets) return false;
		if (rate == 0.0) {
			for(boolean packet: isReceived){
				if (!packet) return false;
			}
			return true;
		}

		int count = 0;
		for(int index = 0; index < isReceived.length; index++){
			if(isReceived[index]){
				count++;
			}
			if((index + 1) % numPacketsInBlock == 0){
				if(count < (numPacketsInBlock - 1)) return false;
				count = 0;
			}
		}
		return true;
	}
	
	@SuppressWarnings("unused")
	private void debug() {
		for(int index = 0; index < isReceived.length; index++) {
			if (!isReceived[index]){
				System.out.println((index+1) + " is missing");
			}
		}
	}

	@Override
	public MoleculeParams encode(MoleculeParams molParams) {
		return molParams;
	}

	@Override
	void recieve(Molecule m) {
		isReceived[m.getNumSequence()-1] = true;
	}

}
