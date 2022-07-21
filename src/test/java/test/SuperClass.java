package test;

public class SuperClass {
	
	public static void main(String[] args) throws Exception {
		
		IdentifyBikes bikesObj = new IdentifyBikes();
		bikesObj.upcomingBikes();
		
		GoogleLogin loginObj = new GoogleLogin();
		loginObj.googleLogin();
		
		UsedCars carsObj = new UsedCars();
		carsObj.usedCars();
		
		QuitDriver qd = new QuitDriver();
		qd.endSession();
		
	}

}
