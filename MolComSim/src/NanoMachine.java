//package MComSim.NanoMachine-context;

import java.io.*;
import java.util.*;

public class NanoMachine {

	public static class Transmitter {

		private MolComSim simulation;
		private int currMsgId = 0;
		private int retransmissionsLeft;
		private MoleculeCreator moleculeCreator;
		private NanoMachine nanoMachine;

		public Transmitter(NanoMachine nm, ArrayList<MoleculeParams> mpl, MolComSim sim) {
			this.nanoMachine = nm;
			this.simulation = sim;
			this.moleculeCreator = new MoleculeCreator(mpl, this.simulation, this.nanoMachine);
			this.currMsgId = 0;
			this.retransmissionsLeft =  this.simulation.getMaxRetransmissions();
		}

		public void createMolecules() {
			/*moleculeCreator.createMoreMolecules(currMsgId);
			countdown = sim.getRetransmissionWaitTime();*/
			throw new UnsupportedOperationException("The method is not implemented yet.");
		}

		public void nextStep() {
			/*if((countdown-- > 0) && (retransmissionsLeft > 0))
		{
			createMolecules();
			retransmissionsLeft--;
		} */
			throw new UnsupportedOperationException("The method is not implemented yet.");
		}

		public void receiveMolecule(Molecule m) {
			/*if(molecule.getMsgId() == currMsgId)
		{
			sim.completedMessage(currMsgId++);
			if(currMsgId < sim.getNumMessages()) 
			{
				createMolecules();
				retransmissionsLeft =  sim.getMaxRetransmissions();
			}
		}
		else if (retransmissionLeft > 0)
		{
			createMolecules();
			retransmissionsLeft--;
		}*/
			throw new UnsupportedOperationException("The method is not implemented yet.");
		}

		public NanoMachine getNanoMachine() {
			return nanoMachine;
		}

		public MolComSim getSimulation() {
			return simulation;
		}

		public int getCurrMsgId() {
			return currMsgId;
		}

	}

	public static class Receiver {

		private MolComSim simulation;
		private int currMsgId;
		private int retransmissionsLeft;
		private MoleculeCreator moleculeCreator;
		private NanoMachine nanoMachine;

		public Receiver(NanoMachine nm, ArrayList<MoleculeParams> mpl, MolComSim sim) {
			this.nanoMachine = nm;
			this.simulation = sim;
			if(this.simulation.isUsingAcknowledgements())
			{
				this.moleculeCreator = new MoleculeCreator(mpl, simulation, nanoMachine);
				currMsgId = 0;
				retransmissionsLeft =  this.simulation.getMaxRetransmissions();
			}
			throw new UnsupportedOperationException("The method is not implemented yet.");
		}

		public void createMolecules() {
			/*moleculeCreator.createMoreMolecules(currMsgId);
		countdown = sim.getRetransmissionWaitTime();*/
			throw new UnsupportedOperationException("The method is not implemented yet.");
		}

		public void nextStep() {
			/*if(sim.isUsingAcknowledgements() && 
			((countdown-- > 0) && (retransmissionsLeft > 0)))
		{
			createMolecules();
			retransmissionsLeft--;
		} */
			throw new UnsupportedOperationException("The method is not implemented yet.");
		}

		public void receiveMolecule(Molecule m) {
			/*if(molecule.getMsgId() == currMsgId + 1)
		{
			currMsgId++;		
			if(sim.isUsingAcknowledgements())
			{
				createMolecules();
				retransmissionsLeft =  sim.getMaxRetransmissions();
			} 
			else
			{
				sim.completedMessage(currMsgId);
			}
		}
		else if (sim.isUsingAcknowledgements() && (retransmissionsLeft > 0))
		{
			createMolecules();
			retransmissionsLeft--;
		}*/
			throw new UnsupportedOperationException("The method is not implemented yet.");
		}

		public NanoMachine getNanoMachine() {
			return nanoMachine;
		}

		public MolComSim getSimulation() {
			return simulation;
		}

		public int getCurrMsgId() {
			return currMsgId;
		}

	}

	private Position position;
	private double radius;
	private MolComSim simulation;
	private Receiver rx;
	private Transmitter tx;

	private NanoMachine(Position psn, double r) {
		this.position = psn;
		this.radius = r;
	}

	public static NanoMachine createTransmitter(Position p, double r, ArrayList<MoleculeParams> mpl, MolComSim sim) {
		/*NanoMachine retVal = new NanoMachine(position, radius);
	retVal.tx = new Transmitter(retVal, molecule params, simulation);
	retVal.rx = null;
	return retVal;*/
	throw new UnsupportedOperationException("The method is not implemented yet.");
	}

	public static NanoMachine createReceiver(Position p, double r, ArrayList<MoleculeParams> mpl, MolComSim sim) {
		/*NanoMachine retVal = new NanoMachine(position, radius);
	retVal.rx = new receiver(retVal, molecule params, simulation);
	retVal.tx = null;
	return retVal;*/
		throw new UnsupportedOperationException("The method is not implemented yet.");
	}

	public static NanoMachine createIntermediateNode(Position p, double r, ArrayList<MoleculeParams> mpl, MolComSim sim) {
		/*NanoMachine retVal = new NanoMachine(position, radius);
	retVal.rx = new receiver(retVal, molecule params, simulation);
	retVal.tx = new Transmitter(retVal, molecule params, simulation);
	return retVal;	*/
		throw new UnsupportedOperationException("The method is not implemented yet.");
	}

	public void createInfoMolecules() {
		/*if(tx != null) 
	{
		tx.createMolecules();
	}*/
		throw new UnsupportedOperationException("The method is not implemented yet.");
	}

	public void nextStep() {
		/*if(tx != null)
	{
		tx.nextStep();
	}
	if(rx != null)
	{
		rx.nextStep();
	}*/
		throw new UnsupportedOperationException("The method is not implemented yet.");
	}

	public void receiveMolecule(Molecule m) {
		/*if(molecule is information && (rx != null))
	{
		rx.receiveMolecule(molecule);
	} 
	else if(molecule is acknowledgement) && (tx != null))
	{
		tx.receiveMolecule(molecule);
	}*/
		throw new UnsupportedOperationException("The method is not implemented yet.");
	}

	public Position getPosition() {
		return position;
	}

	public double getRadius() {
		return radius;
	}

	public MolComSim getSimulation() {
		return simulation;
	}

}
