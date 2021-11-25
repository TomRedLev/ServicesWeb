package fr.eiffelcorp.ifshare.rmi.client;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import fr.eiffelcorp.ifshare.rmi.common.IProduct;

@SuppressWarnings("serial")
public class Product extends UnicastRemoteObject implements IProduct {
	private String name;
	private String type;
	private String seller;
	private Double price;
	private String comment;
	

	protected Product() throws RemoteException {
		super();
		this.name = "";
		this.type = "";
		this.seller = "";
		this.price = 0d;
		this.comment = "";
	}
	
	protected Product(String name, String type, String seller, Double price, String comment) throws RemoteException {
		super();
		this.name = name;
		this.type = type;
		this.seller = seller;
		this.price = price;
		this.comment = comment;
	}

	@Override
	public String getName() throws RemoteException {
		return name;
	}

	@Override
	public String getType() throws RemoteException {
		return type;
	}
	
	@Override
	public String getSeller() {
		return seller;
	}

	@Override
	public Double getPrice() throws RemoteException {
		return price;
	}

	@Override
	public String getComment() throws RemoteException {
		return comment;
	}

	@Override
	public void setName(String name) throws RemoteException {
		this.name = name;
	}

	@Override
	public void setType(String type) throws RemoteException {
		this.type = type;
	}
	
	@Override
	public void setSeller(String seller) throws RemoteException {
		this.seller = seller;
	}
	
	@Override
	public void setPrice(Double price) throws RemoteException {
		this.price = price;
	}
	
	@Override
	public void setComment(String comment) throws RemoteException {
		this.comment = comment;
	}
	
	@Override
	public String getInfo() throws RemoteException {
		return "Product { name : " + name 
		+ ", type : " + type
		+ ", seller : " + seller
		+ ", price : " + price
		+ ", comment : " + comment + "}";
	}
}
