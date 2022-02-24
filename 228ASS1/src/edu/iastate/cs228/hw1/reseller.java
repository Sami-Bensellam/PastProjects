package edu.iastate.cs228.hw1;

public class reseller extends TownCell{

	public reseller(Town p, int r, int c) {
		super(p, r, c);
		// TODO Auto-generated constructor stub
	}

	@Override
	public State who() {
		return State.RESELLER;
	}

	@Override
	public TownCell next(Town tNew) {
		census(nCensus);
		if(nCensus[CASUAL]<4) {
			empty e = new empty(plain, row, col);
			
			return e;
		}
		if(nCensus[EMPTY]>2) {
			empty e = new empty(plain, row, col);
			
			return e;
		}
		if(nCensus[CASUAL]>4) {
			streamer s = new streamer(plain, row, col);
			
			return s;
		}		
		else {
			reseller r = new reseller(plain,col,row);
			return r;
		}
		}

}
