
public class Car {

	private String marka;
	private String rok;
	private String silnik;
	private String maxPrędkośc;
	
	
	public Car(String marka, String rok, String silnik, String maxPrędkośc) {
		super();
		this.marka = marka;
		this.rok = rok;
		this.silnik = silnik;
		this.maxPrędkośc = maxPrędkośc;
	}
	


	public String getMarka() {
		return marka;
	}



	public void setMarka(String marka) {
		this.marka = marka;
	}



	public String getRok() {
		return rok;
	}



	public void setRok(String rok) {
		this.rok = rok;
	}



	public String getSilnik() {
		return silnik;
	}



	public void setSilnik(String silnik) {
		this.silnik = silnik;
	}



	public String getMaxPrędkośc() {
		return maxPrędkośc;
	}



	public void setMaxPrędkośc(String maxPrędkośc) {
		this.maxPrędkośc = maxPrędkośc;
	}



	public Car() {
		
	}



	public String Print() {
		return "Car [marka=" + marka + ", rok=" + rok + ", silnik=" + silnik + ", maxPrędkośc=" + maxPrędkośc + "]";
	}
	
	
}
