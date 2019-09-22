
public class MedicalPay implements AutoInsurance{
	private String description;
	@Override
	public String getInfo() {
		description = " Medical Payments Coverage: \n\nUsually optional, this coverage pays for medical expenses over and above amounts covered by personal insurance protection, no matter who caused the accident. ";
		return description;
	}

}
