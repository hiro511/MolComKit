/**
 * Stores all the parameters needed to define
 * a particular simulation instance
 * 
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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
	private ArrayList<MicrotubuleParams> microtubuleParams;
	//private ArrayList<Double> microtubuleRadii;
	private int numMessages;
	private int maxNumSteps;
	private int numRetransmissions;
	private int retransmitWaitTime;
	private boolean useCollisions;
	private boolean useAcknowledgements;
	private ArrayList<MoleculeParams> moleculeParams;
	private double molRandMoveX;
	private double molRandMoveY;
	private double molRandMoveZ;
	private double velRail;
	private double probDRail;
	
	private HashMap<String, Object> allParams;

	public SimulationParams(String[] args) {
		allParams = new HashMap<String, Object>();
		parseArgs(args);
		try {
			readParamsFile(paramsFileName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void parseArgs(String[] args) {
		/*parses command line arguments, stores them in fields
	args can include type of movement for acknowledgement, information, 
	and noise molecules (passive = default for info and ack, 
	stationary = default for noise).  
	Indicated with: -(tx|rx|no): (active|passive|stationary) 
	(where no stands for noise)
	args can include type of Automatic Repeat Request scheme used 
	(currently none is default, for no acknowledgement molecules, 
	change to sw11 later).  Indicated with: arq: (sw)(1..n),(1..m) , 
	where sw means stop-and-wait (might implement 
	other ARQ schemes later, the next integer value represents the 
	number of information molecules to send (minimum 1), and the next 
	integer value represents the number of acknowledgement molecules to send.
	args can include input file location/name (default: params.dat).  
	Indicated with: pfile:<string>.  
	paramsFile must be set up in parseArgs, but not opened for reading.*/
		//throw new UnsupportedOperationException("The method is not implemented yet.");
		if (args.length == 0){
			paramsFileName = "input0.dat";
		}
	}

	/** UNFINISHED METHOD*/
	private void readParamsFile(String fName) throws IOException{
		/*open params file for reading
	Reads params from paramsFile (field), each param type is identified by the first string starting a line, although its values may extend over multiple lines (for example, to make it easier to view arrays of things).  Stores each param’s value(s) in a
 	private field.  Alternatively, we could do this with a hashmap of key, value pairs, where the key is the String representing the name of the parameter and the value is of Object type so it can be anything we want.  Not sure which is the better way
 	to go.  
	close param file for reading*/
		/*LEGACY CODE*/
		//TODO: Can this be improved?
		//TODO: Make sure all parameters are accounted for and line up between file and this method
		boolean flag = true;
		
		/* Something like, while next, if next in allParams, 
		 * then add the one after that as value for that key in allParams
		 * Will need a lot of error checking
		 */
		
		String line;
		BufferedReader br = new BufferedReader(new FileReader(fName));
		
		//TODO: fix this, just need to make sure arraylists are initialized
		transmitterPositions = new ArrayList<Position>();
		receiverPositions = new ArrayList<Position>();
		//placeholder for a real way to parse microtubule/molecule params
		MicrotubuleParams mtp;
		Position plus = null;
		Position minus = null;
		Double mtRadius = null;
		Integer numMolecules = null;
		Double mRadius = null;
		MoleculeType moleculeType = null;
		MoleculeMovementType moleculeMovementType = null;
		MoleculeParams mp;
		while((line = br.readLine())!=null){
			String param = "";
			if(!line.equals(""))
				param = line.substring(line.indexOf(" ")+1).trim();
			if(line.startsWith("stepLengthX")){
				molRandMoveX = Double.parseDouble(param);
			}
			else if(line.startsWith("stepLengthY")){
				molRandMoveY = Double.parseDouble(param);
			}
			else if(line.startsWith("stepLengthZ")){
				molRandMoveZ = Double.parseDouble(param);
			}
			else if(line.startsWith("mediumDimensionX")){
				mediumLength = Double.parseDouble(param);
			}
			else if(line.startsWith("mediumDimensionY")){
				mediumWidth = Double.parseDouble(param);				
			}
			else if(line.startsWith("mediumDimensionZ")){
				mediumHeight = Double.parseDouble(param);
			}		
			else if (line.startsWith("maxSimulationStep")){
				maxNumSteps = Integer.parseInt(param);
			}
			else if(line.startsWith("receiverRadius")){
				receiverRadius = Double.parseDouble(param);				
			}
			else if(line.startsWith("transmitterRadius")){
				transmitterRadius = Double.parseDouble(param);				
			}
			else if(line.startsWith("intermediateNodeRadius")){
				intermediateNodeRadius = Double.parseDouble(param);				
			}
			else if(line.startsWith("numMessages")){
				numMessages = Integer.parseInt(param);				
			}
			else if(line.startsWith("numRetransmissions")){
				numRetransmissions = Integer.parseInt(param);				
			}
			else if(line.startsWith("retransmitWaitTime")){
				retransmitWaitTime = Integer.parseInt(param);				
			}
			else if(line.startsWith("useCollisions")){
				//how are we coding booleans in the params file?
				useCollisions = (Integer.parseInt(param) == 1) ? true : false;
			}
			else if(line.startsWith("useAcknowledgements")){
				//how are we coding booleans in the params file?
				useAcknowledgements = (Integer.parseInt(param) == 1) ? true : false;
			}
			else if(line.startsWith("velRail")){
				velRail = Double.parseDouble(param);				
			}
			else if(line.startsWith("probDRail")){
				probDRail = Double.parseDouble(param);				
			}
			//TODO: fix this
			else if(line.startsWith("transmitterPosition")){
				double x = Double.parseDouble(param.substring(1,param.indexOf(",")));
				double y = Double.parseDouble(param.substring(
						param.indexOf(",")+1, 
						param.indexOf(",", param.indexOf(",")+1)));
				double z = Double.parseDouble(param.substring(
						param.indexOf(",", param.indexOf(",")+1)+1, 
						param.length()-1));
				Position tPos = new Position(x, y, z);
				transmitterPositions.add(tPos);
			}
			else if(line.startsWith("receiverPosition")){
				double x = Double.parseDouble(param.substring(1,param.indexOf(",")));
				double y = Double.parseDouble(param.substring(
						param.indexOf(",")+1, 
						param.indexOf(",", param.indexOf(",")+1)));
				double z = Double.parseDouble(param.substring(
						param.indexOf(",", param.indexOf(",")+1)+1, 
						param.length()-1));
				Position rPos = new Position(x, y, z);
				receiverPositions.add(rPos);
			}
			//TODO: fix this
			//placeholder for a real way to read in molecule params

			else if (line.startsWith("radiusOfMolecule")){
				mRadius = Double.parseDouble(param);
			}
			else if (line.startsWith("numMolecules")){
				numMolecules = Integer.parseInt(param);
			}
			else if (line.startsWith("moleculeType")){
				//TODO: fill in other options
				if (param.equals("INFO"))
					moleculeType = MoleculeType.INFO;
			}
			else if (line.startsWith("moleculeMovementType")){
				//TODO: fill in other options
				if (param.equals("PASSIVE"))
					moleculeMovementType = MoleculeMovementType.PASSIVE;
			}

			//placeholder for a real way to read in microtubule params
			else if(line.startsWith("plusEndCentre")){
				double x = Double.parseDouble(param.substring(1,param.indexOf(",")));
				double y = Double.parseDouble(param.substring(
						param.indexOf(",")+1, 
						param.indexOf(",", param.indexOf(",")+1)));
				double z = Double.parseDouble(param.substring(
						param.indexOf(",", param.indexOf(",")+1)+1, 
						param.length()-1));
				plus = new Position(x, y, z);
			}
			else if(line.startsWith("minusEndCentre")){
				double x = Double.parseDouble(param.substring(1,param.indexOf(",")));
				double y = Double.parseDouble(param.substring(
						param.indexOf(",")+1, 
						param.indexOf(",", param.indexOf(",")+1)));
				double z = Double.parseDouble(param.substring(
						param.indexOf(",", param.indexOf(",")+1)+1, 
						param.length()-1));
				minus = new Position(x, y, z);
			}
			else if(line.startsWith("radiusMicroTubule")){
				mtRadius = Double.parseDouble(param);				
			}
		}
		mtp = new MicrotubuleParams(plus, minus, mtRadius);
		mp = new MoleculeParams(moleculeType, moleculeMovementType, numMolecules, mRadius);
		moleculeParams = new ArrayList<MoleculeParams>();
		microtubuleParams = new ArrayList<MicrotubuleParams>();
		moleculeParams.add(mp);
		microtubuleParams.add(mtp);
		br.close();
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
		return transmitterPositions;
	}

	public ArrayList<Position> getReceiverPositions() {
		return receiverPositions;
	}

	public ArrayList<Position> getIntermediateNodePositions() {
		return intermediateNodePositions;
	}

	/*public ArrayList<Position> getMicrotubulePlusEndPoints() {
		throw new UnsupportedOperationException("The method is not implemented yet.");
	}

	public ArrayList<Position> getMicrotubuleMinusEndPoints() {
		throw new UnsupportedOperationException("The method is not implemented yet.");
	}*/

	public double getTransmitterRadius() {
		return transmitterRadius;
	}

	public double getReceiverRadius() {
		return receiverRadius;
	}

	public double getIntermediateNodeRadius() {
		return intermediateNodeRadius;
	}

	public ArrayList<MicrotubuleParams> getMicrotubuleParams() {
		return microtubuleParams;
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
		return useAcknowledgements;
	}

	public double getMolRandMoveX() {
		return molRandMoveX;
	}

	public double getMolRandMoveY() {
		return molRandMoveY;
	}

	public double getMolRandMoveZ() {
		return molRandMoveZ;
	}

	public double getVelRail() {
		return velRail;
	}

	public double getProbDRail() {
		return probDRail;
	}

	public int getMaxNumSteps() {
		return maxNumSteps;
	}

	public int getNumMessages() {
		return numMessages;
	}

}
