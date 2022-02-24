package edu.iastate.cs228.hw1;

public class streamer extends TownCell {

	public streamer(Town p, int r, int c) {
		super(p, r, c);

	}

	@Override
	public State who() {
		return State.STREAMER;
	}

	@Override
	public TownCell next(Town tNew) {
		census(nCensus);
		if (nCensus[RESELLER] > 0) {
			return new outage(plain, row, col);
		}
		else if(nCensus[OUTAGE]+nCensus[EMPTY]>0) {
			reseller r = new reseller(plain,row,col);
			
			return r;
		}
		else if (nCensus[OUTAGE]>0) {
			empty e = new empty(plain, row, col);
			return e;
		}
		else { 
			streamer s = new streamer(plain, row, col);

		return s;
	}
	}

}
