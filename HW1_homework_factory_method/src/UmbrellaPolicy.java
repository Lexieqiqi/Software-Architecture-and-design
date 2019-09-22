
public class UmbrellaPolicy implements PolicyProducer{

	@Override
	public AutoInsurance getAutoObj() {
		// TODO Auto-generated method stub
		return new Umbrella();
	}

}
