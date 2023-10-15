package Service;



import Metier.Compte;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(serviceName="BanqueWS")
public class BankService {
	@WebMethod(operationName="ConversionEuroToDh")
	public double conversion(@WebParam double mont)
	{
		return mont*3.5;
	}
	@WebMethod
	public void retirer(Compte c,double mont)
	{
		c.setSolde(c.getSolde()-mont);
	}
	@WebMethod
	public void verser(Compte c,double mont)
	{
		c.setSolde(c.getSolde()+mont);
	}
}

