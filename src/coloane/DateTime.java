/**
 * Clasa ce reprezinta implementarea unei structuri ce stocheaza o data
 */
package coloane;

import lant_policlinici.ErrorLog;

/**
 * @author Vali
 *
 */
public class DateTime {
	private int an;
	private int luna;
	private int zi;
	
	private int ora;
	private int minute;
	private int secunde;
	
	public DateTime(int an, int luna, int zi, int ora, int minute, int secunde) {
		this.setAn(an);
		this.setLuna(luna);
		this.setZi(zi);
		this.setOra(ora);
		this.setMinute(minute);
		this.setSecunde(secunde);
	}
	
	public DateTime() {
		this.setAn(1001);
		this.setLuna(1);
		this.setZi(1);
		this.setOra(0);
		this.setMinute(0);
		this.setSecunde(0);
	}

	public String getAn() {
		return new String("" + an + "");
	}

	public void setAn(int an) {
		if (an < 1000 || an > 9999)
			ErrorLog.printError("Incercare invalida de a seta anul.");
		else
			this.an = an;
	}

	public String getZi() {
		String str = new String("");
		
		if (zi > 0 && zi < 10)
			str += "0" + zi;
		else
			str += zi;
		
		return str;
	}

	public void setZi(int zi) {
		int[] maxDays1 = new int[] {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		int[] maxDays2 = new int[] {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		int[] maxDays;
		
		if (an % 4 == 0) {
			maxDays = maxDays2;
		} else {
			maxDays = maxDays1;
		}
		
		if (zi < 1 || zi > maxDays[luna])
			ErrorLog.printError("Incercare invalida de a seta ziua.");
		else
			this.zi = zi;
	}

	public String getLuna() {
		String str = new String("");
		
		if (luna > 0 && luna < 10)
			str += "0" + luna;
		else
			str += luna;
		
		return str;
	}

	public void setLuna(int luna) {
		if (luna < 1 || luna > 12)
			ErrorLog.printError("Incercare invalida de a seta luna.");
		else
			this.luna = luna;
	}

	public String getOra() {
		String str = new String("");
		
		if (ora >= 0 && ora < 10)
			str += "0" + ora;
		else
			str += ora;
		
		return str;
	}

	public void setOra(int ora) {
		if (ora < 0 || ora > 23)
			ErrorLog.printError("Incercare invalida de a seta ora.");
		else
			this.ora = ora;
	}

	public String getMinute() {
		String str = new String("");
		
		if (minute >= 0 && minute < 10)
			str += "0" + minute;
		else
			str += minute;
		
		return str;
	}

	public void setMinute(int minute) {
		if (ora < 0 || ora > 59)
			ErrorLog.printError("Incercare invalida de a seta minutele.");
		else
			this.minute = minute;
	}

	public String getSecunde() {
		String str = new String("");
		
		if (secunde >= 0 && secunde < 10)
			str += "0" + secunde;
		else
			str += secunde;
		
		return str;
	}

	public void setSecunde(int secunde) {
		if (secunde < 0 || secunde > 59)
			ErrorLog.printError("Incercare invalida de a seta secundele.");
		else
			this.secunde = secunde;
	}
	
	public String toString() {
		return new String(getZi() + "/" + getLuna() + "/" + getAn() + " " + getOra() + ":" + getMinute() + ":" + getSecunde());
	}
	
	public String convertToDate() {
		return new String(getAn() + "-" + getLuna() + "-" + getZi());
	}
	
	public String convertToDateTime() {
		return new String(getAn() + "-" + getLuna() + "-" + getZi() + " " + getOra() + ":" + getMinute() + ":" + getSecunde());
	}
}
