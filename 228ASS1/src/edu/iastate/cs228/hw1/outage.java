package edu.iastate.cs228.hw1;

public class outage extends TownCell{

	public outage(Town p, int r, int c) {
		super(p, r, c);
		// TODO Auto-generated constructor stub
	}

	@Override
	public State who() {
		// TODO Auto-generated method stub
		return State.OUTAGE;
	}

	@Override
	public TownCell next(Town tNew) {
		census(nCensus);
	empty e = new empty(plain,row,col);
		return e;
	}



}
