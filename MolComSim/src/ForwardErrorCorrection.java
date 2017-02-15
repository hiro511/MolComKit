import java.util.Arrays;

public abstract class ForwardErrorCorrection {
	protected double rate;
	protected int numPackets;
	protected int numRequiredPackets;
	protected int numParityPackets;
	protected int numPacketsInBlock;
	protected boolean isReceived[] = null;
	protected int numRecievedPackets = 0;
	
	public ForwardErrorCorrection(double rate, int numRequiredPackets) {
		this.rate = rate;
		this.numRequiredPackets = numRequiredPackets;
		this.numParityPackets = (int) (numRequiredPackets * rate);
		this.numPacketsInBlock = (int) (1 / rate) + 1;
		this.numPackets = (int)(numRequiredPackets * (rate + 1.0));
		this.isReceived = new boolean[this.numPackets];
		Arrays.fill(isReceived, false);
	}
	
	abstract boolean canAssemble();
	
	public void add(Molecule m) {
		numRecievedPackets++;
		isReceived[m.getNumSequence()-1] = true;
	}
	
	public int getNumRecievedPackets() {
		return numRecievedPackets;
	}
}
