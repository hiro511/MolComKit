//package MComSim.MolComSim;

import java.io.*;
import java.util.*;

public class MolComSim {

	private FileReader paramsFile;
	private int simStep;
	private boolean lastMsgCompleted;
	private ArrayList<Molecule> molecules;
	private int messagesCompleted;
	private SimulationParams simParams;
	private ArrayList<Microtubule> microtubules;
	private ArrayList<NanoMachine> nanoMachines;
	private Medium medium;
	private ArrayList<NanoMachine> transmitters;
	private ArrayList<NanoMachine> receivers;

	public static void main(String[] args) {
		MolComSim molComSim = createInstance(); //does this mean that molcomsim has an instance of itself?
		molComSim.run(args);
	}

	private void startSim(String[] args) {
		simStep = 0;
		lastMsgCompleted = false;
		simParams = new SimulationParams(args);
		createMedium();
		createNanoMachines();
		createMicrotubules();		
		// Note: it is the job of the medium and NanoMachines to create molecules
	}

	public static MolComSim createInstance() {
		/*if(molComSim == null)
		{
			molComSim = new MolComSim();
		}
		return molComSim;*/
		throw new UnsupportedOperationException("The method is not implemented yet.");
	}

	private void run(String[] args) {
		startSim(args);
		for(; (simStep < simParams.getMaxNumSteps()) && (!lastMsgCompleted); simStep++) 
		{
			for(NanoMachine nm : nanoMachines){
				nm.nextStep();
			}
			for(Molecule m : molecules){	
				m.move();
			}
		}
		endSim();
	}

	public int getSimStep() {
		return simStep;
	}

	public boolean isLastMsgCompleted() {
		return lastMsgCompleted;
	}

	private void createMedium() {
		/*get Medium params, NoiseMolecule params from simParams
		medium = new Medium(medum params, noise molecule params, this);
		medium.createMolecules();*/
		throw new UnsupportedOperationException("The method is not implemented yet.");
	}

	private void createNanoMachines() {
		/*for(each NanoMachine specified by simParams)
	{
		get NanoMachine params, Info/Ack molecule params to be released by this NanoMachine from simParams
		construct a temporary nano machine, by calling NanoMachine method createTransmitter, createReceiver, or createIntermediateNode, and passing it the nano machine params, the molecule params, and this simulation object. 
		If we are creating a transmitter, add it to the list of transmitters. 
		If we are creating a receiver add it to the list of receivers.  
		If we are creating an intermediate note add it to both the list of transmitters and the list of receivers.
		tempNanoMachine.createInfoMolecules();
		nanoMachineList.add(tempNanoMachine);
	}*/
		throw new UnsupportedOperationException("The method is not implemented yet.");
	}

	private void createMicrotubules() {
		/*for(each MicroTubule specified by simParams)
	{
		get microtubule params from simParams
		construct a temporary microtubule, passing it the microtubule params and this simulation object
		microTubuleList.add(tempMicroTubule);
	}*/
		throw new UnsupportedOperationException("The method is not implemented yet.");
	}

	//any cleanup tasks, including printing simulation results to monitor or file.
	private void endSim() {
		throw new UnsupportedOperationException("The method is not implemented yet.");
	}

	//add molecules to molecules list field
	public void addMolecules(ArrayList<Molecule> mols) {
		this.molecules.addAll(mols);
	}

	public void completedMessage(int msgNum) {
		/*possibly print results to file and/or monitor
	if(msgId >= numMsgs – 1)
	{
		lastMsgCompleted = true;
	}*/
		throw new UnsupportedOperationException("The method is not implemented yet.");
	}

	public int getMessagesCompleted() {
		return messagesCompleted;
	}

	public SimulationParams getSimParams() {
		return simParams;
	}

	public ArrayList<Molecule> getMolecules() {
		return molecules;
	}

	public ArrayList<Microtubule> getMicrotubules() {
		return microtubules;
	}

	public ArrayList<NanoMachine> getNanoMachines() {
		return nanoMachines;
	}

	public Medium getMedium() {
		return medium;
	}

	public ArrayList<NanoMachine> getReceivers() {
		return receivers;
	}

	public ArrayList<NanoMachine> getTransmitters() {
		return transmitters;
	}

	public boolean isUsingAcknowledgements() {
		// TODO Auto-generated method stub
		return false;
	}

	public int getMaxRetransmissions() {
		// TODO Auto-generated method stub
		return 0;
	}

}
