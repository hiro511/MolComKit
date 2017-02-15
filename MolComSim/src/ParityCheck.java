
public class ParityCheck extends ForwardErrorCorrection{

	public ParityCheck(double rate, int numRequiredPackets) {
		super(rate, numRequiredPackets);
	}

	@Override
	boolean canAssemble() {
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
	
	private void debug() {
		for(int index = 0; index < isReceived.length; index++) {
			if (!isReceived[index]){
				System.out.println((index+1) + " is missing");
			}
		}
	}

}
