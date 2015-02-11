
public class PrivateInvestment {
	private String code;
	private String label;
	private double quarterlyDividend;
	private double baseRateOfReturn;
	private double omegaMeasure;
	private double totalValue;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public double getQuarterlyDividend() {
		return quarterlyDividend;
	}
	public void setQuarterlyDividend(double quarterlyDividend) {
		this.quarterlyDividend = quarterlyDividend;
	}
	public double getBaseRateOfReturn() {
		return baseRateOfReturn;
	}
	public void setBaseRateOfReturn(double baseRateOfReturn) {
		this.baseRateOfReturn = baseRateOfReturn;
	}
	public double getOmegaMeasure() {
		return omegaMeasure;
	}
	public void setOmegaMeasure(double omegaMeasure) {
		this.omegaMeasure = omegaMeasure;
	}
	public double getTotalValue() {
		return totalValue;
	}
	public void setTotalValue(double totalValue) {
		this.totalValue = totalValue;
	}
	
	public PrivateInvestment(){
		code = "";
		label = "";
		quarterlyDividend = 0.0;
		baseRateOfReturn = 0.0;
		omegaMeasure = 0.0;
		totalValue = 0.0;		
	}
	public PrivateInvestment(String code, String label,
			double quarterlyDividend, double baseRateOfReturn,
			double omegaMeasure, double totalValue) {
		this.code = code;
		this.label = label;
		this.quarterlyDividend = quarterlyDividend;
		this.baseRateOfReturn = baseRateOfReturn;
		this.omegaMeasure = omegaMeasure;
		this.totalValue = totalValue;
	}
	
	

}
