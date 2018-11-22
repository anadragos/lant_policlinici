package coloane;

public class OraProgram {
	private int inceput;
	private int sfarsit;
	private boolean open;
	
	public OraProgram(int inceput, int sfarsit) {
		this.setInceput(inceput);
		this.setSfarsit(sfarsit);
		this.setOpen(true);
	}
	
	public OraProgram() {
		this(0, 24);
	}
	
	public OraProgram(boolean open) {
		this.setOpen(open);
	}

	public int getInceput() {
		return inceput;
	}

	public void setInceput(int inceput) {
		this.inceput = inceput;
	}

	public int getSfarsit() {
		return sfarsit;
	}

	public void setSfarsit(int sfarsit) {
		this.sfarsit = sfarsit;
	}

	public boolean isOpen() {
		return open;
	}

	public void setOpen(boolean open) {
		this.open = open;
	}
}