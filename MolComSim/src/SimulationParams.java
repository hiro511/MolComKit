//package MComSim.SimulationParams;

import java.util.*;

public class SimulationParams {

	private String paramsFileName;
	private double mediumLength;
	private double mediumWidth;
	private double mediumHeight;
	private ArrayList<Position> transmitterPositions;
	private double transmitterRadius;
	private ArrayList<Position> receiverPositions;
	private double receiverRadius;
	private ArrayList<Position> intermediateNodePositions;
	private double intermediateNodeRadius;
	private ArrayList<Position> microtubulePlusEndPoints;
	private ArrayList<Position> microtubuleMinusEndPoints;
	private ArrayList<Double> microtubuleRadii;
	private int numMessages;
	private int maxNumSteps;
	private int numRetransmissions;
	private int retransmitWaitTime;
	private boolean useCollisions;
	private ArrayList<MoleculeParams> moleculeParams;
	private double molRandMoveX;
	private double molRandMoveY;
	private double molRandMoveZ;
	private double velRail;
	private double probDRail;

	public int getMaxNumSteps() {
		return maxNumSteps;
	}

	public int getNumMessages() {
		return numMessages;
	}

	public SimulationParams(String[] args) {
		parseArgs(args);
		readParamsFile(paramsFileName);
	}

	private void parseArgs(String[] args) {
		/*parses command line arguments, stores them in fields
	args can include type of movement for acknowledgement, information, and noise molecules (passive = default for info and ack, stationary = default for noise).  Indicated with: -(tx|rx|no): (active|passive|stationary) (where no stands for noise)
	args can include type of Automatic Repeat Request scheme used (currently none is default, for no acknowledgement molecules, change to sw11 later).  Indicated with: arq: (sw)(1..n),(1..m) , where sw means stop-and-wait (might implement 
	other ARQ schemes later, the next integer value represents the number of information molecules to send (minimum 1), and the next integer value represents the number of acknowledgement molecules to send.
	args can include input file location/name (default: params.dat).  Indicated with: pfile:<string>.  paramsFile must be set up in parseArgs, but not opened for reading.*/
		throw new UnsupportedOperationException("The method is not implemented yet.");
	}

	private void readParamsFile(String fName) {
		/*open params file for reading
	Reads params from paramsFile (field), each param type is identified by the first string starting a line, although its values may extend over multiple lines (for example, to make it easier to view arrays of things).  Stores each param’s value(s) in a
 	private field.  Alternatively, we could do this with a hashmap of key, value pairs, where the key is the String representing the name of the parameter and the value is of Object type so it can be anything we want.  Not sure which is the better way
 	to go.  
	close param file for reading*/
		throw new UnsupportedOperationException("The method is not implemented yet.");
	}

	public double getMediumLength() {
		return mediumLength;
	}

	public double getMediumWidth() {
		return mediumWidth;
	}

	public double getMediumHeight() {
		return mediumHeight;
	}

	public ArrayList<MoleculeParams> getAllMoleculeParams() {
		return moleculeParams;
	}

	//am I understanding these getParams methods correctly?
	public ArrayList<MoleculeParams> getNoiseMoleculeParams() {
		ArrayList<MoleculeParams> noiseMParams = new ArrayList<MoleculeParams>();
		for (MoleculeParams mp : moleculeParams){
			if (mp.getMoleculeType().equals(MoleculeType.NOISE)){
				noiseMParams.add(mp);
			}
		}
		return noiseMParams;
	}

	public ArrayList<MoleculeParams> getInformationMoleculeParams() {
		ArrayList<MoleculeParams> infoMParams = new ArrayList<MoleculeParams>();
		for (MoleculeParams mp : moleculeParams){
			if (mp.getMoleculeType().equals(MoleculeType.INFO)){
				infoMParams.add(mp);
			}
		}
		return infoMParams;
	}

	public ArrayList<MoleculeParams> getAcknowledgmentMoleculeParams() {
		ArrayList<MoleculeParams> ackMParams = new ArrayList<MoleculeParams>();
		for (MoleculeParams mp : moleculeParams){
			if (mp.getMoleculeType().equals(MoleculeType.ACK)){
				ackMParams.add(mp);
			}
		}
		return ackMParams;
	}

	public ArrayList<Position> getTransmitterPositions() {
		throw new UnsupportedOperationException("The method is not implemented yet.");
	}

	public ArrayList<Position> getReceiverPositions() {
		throw new UnsupportedOperationException("The method is not implemented yet.");
	}

	public ArrayList<Position> getIntermediateNodePositions() {
		throw new UnsupportedOperationException("The method is not implemented yet.");
	}

	public ArrayList<Position> getMicrotubulePlusEndPoints() {
		throw new UnsupportedOperationException("The method is not implemented yet.");
	}

	public ArrayList<Position> getMicrotubuleMinusEndPoints() {
		throw new UnsupportedOperationException("The method is not implemented yet.");
	}

	public double getTransmitterRadius() {
		return transmitterRadius;
	}

	public double getReceiverRadius() {
		return receiverRadius;
	}

	public double getIntermediateNodeRadius() {
		return intermediateNodeRadius;
	}

	public ArrayList<Double> getMicrotubuleRadii() {
		return microtubuleRadii;
	}

	public int getNumRetransmissions() {
		return numRetransmissions;
	}

	public int getRetransmitWaitTime() {
		return retransmitWaitTime;
	}

	public boolean isUsingCollisions() {
		return useCollisions;
	}

	public boolean isUsingAcknowledgements() {
		throw new UnsupportedOperationException("The method is not implemented yet.");
	}

	public double getMolRandMoveX() {
		throw new UnsupportedOperationException("The method is not implemented yet.");
	}

	public double getMolRandMoveY() {
		throw new UnsupportedOperationException("The method is not implemented yet.");
	}

	public double getMolRandMoveZ() {
		throw new UnsupportedOperationException("The method is not implemented yet.");
	}

	public double getVelRail() {
		return velRail;
	}

	public double getProbDRail() {
		return probDRail;
	}

}
