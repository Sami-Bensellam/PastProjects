package edu.iastate.cs228.hw1;

public class casual extends TownCell{

	public casual(Town p, int r, int c) {
		super(p, r, c);
		// TODO Auto-generated constructor stub
	}

	@Override
	public State who() {
		return State.CASUAL;
	}

	@Override
	public TownCell next(Town tNew) {
		census(nCensus);
		if (nCensus[RESELLER] > 0) {
			return new outage(tNew, row, col);
		}
		else if(nCensus[STREAMER]>0) {
			streamer s = new streamer(tNew, row, col);

			return s;
		}
		else if(nCensus[OUTAGE]+nCensus[EMPTY]< 2) {
			reseller r = new reseller(tNew,row,col);

			return r;
		}
		else if(nCensus[CASUAL]>4) {
			streamer s = new streamer(tNew, row, col);

			return s;
		}
		else {
			casual c = new casual(tNew, row, col);
			return c;
		}
	}

}
