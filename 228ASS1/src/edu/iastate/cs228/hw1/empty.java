package edu.iastate.cs228.hw1;

public class empty extends TownCell{

	public empty(Town p, int r, int c) {
		super(p, r, c);
		// TODO Auto-generated constructor stub
	}

	@Override
	public State who() {
		return State.EMPTY;
	}

	@Override
	public TownCell next(Town tNew) {
		census(nCensus);
		if((nCensus[OUTAGE]+ nCensus[EMPTY]) < 2) {
			reseller r = new reseller(plain,row,col);

			return r;
		}
		else { 
			casual c = new casual(plain, row, col);
			return c;
		}
	}
}
