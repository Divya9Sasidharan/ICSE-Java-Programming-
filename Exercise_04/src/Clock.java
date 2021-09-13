public class Clock implements Comparable<Clock> {
	private int h; // hours (0-23)

	private int min; // minutes (0-59)

	private int gmin; // total minutes

	// in set-Methoden update gmin!!!

	public Clock() {
		h = 0;
		min = 0;
		gmin = 0;
	}

	public int getH() {
		return h;
	}

	public int getMin() {
		return min;
	}

	public Clock(int h, int min) {
		assert (0 <= h && h <= 23 && 0 <= min && min <= 59) : "unallowable time";
		this.h = h;
		this.min = min;
		gmin = h * 60 + min;
	}

	public Clock(int min) {
		h = (min / 60) % 24;
		this.min = min % 60;
		gmin = h * 60 + this.min;
	}

	public Clock(String z) {
		String[] el = z.split(":");
		h = Integer.parseInt(el[0]);
		min = Integer.parseInt(el[1]);
		gmin = h * 60 + min;
	}

	public Clock add(int m) {
		int res = gmin + m;
		return new Clock(res);
	}
        public Clock add(Clock t) {
		int res = gmin + t.gmin;
		return new Clock(res);
	}

	public String toString() {
		String erg = "";
		erg += h + ":";
		if (min < 10)
			erg += "0";
		erg += min;
		return erg;
	}
	public int compareTo(Clock o) {
		int value1=h*60+min;
		int value2=o.h*60+o.min;
		if(value1 == value2)
			return 0;
		else if (value1>value2)
			return 1;
		else
			return -1;

	}

}