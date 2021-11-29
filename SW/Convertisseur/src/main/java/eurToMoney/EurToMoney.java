package eurToMoney;

import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import com.currencysystem.webservices.currencyserver.CurncsrvReturnRate;
import com.currencysystem.webservices.currencyserver.CurrencyServerLocator;
import com.currencysystem.webservices.currencyserver.CurrencyServerSoap;

public class EurToMoney {
	public double convertToJpy(double montant) throws ServiceException, RemoteException {
		
		CurrencyServerSoap currencySystem = new CurrencyServerLocator().getCurrencyServerSoap();
		
		return montant * (double) currencySystem.rate("", "EUR", "JPY", false, "", CurncsrvReturnRate.curncsrvReturnRateNumber, "", "");
	}
	
	public double convertToGpb(double montant) throws ServiceException, RemoteException {
		
		CurrencyServerSoap currencySystem = new CurrencyServerLocator().getCurrencyServerSoap();
		
		return montant * (double) currencySystem.rate("", "EUR", "GBP", false, "", CurncsrvReturnRate.curncsrvReturnRateNumber, "", "");
	}
	
	public double convertToUsd(double montant) throws ServiceException, RemoteException {
		
		CurrencyServerSoap currencySystem = new CurrencyServerLocator().getCurrencyServerSoap();
		
		return montant * (double) currencySystem.rate("", "EUR", "USD", false, "", CurncsrvReturnRate.curncsrvReturnRateNumber, "", "");
	}
}