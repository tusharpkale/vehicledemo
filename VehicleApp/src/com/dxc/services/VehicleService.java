package com.dxc.services;

import com.dxc.daos.VehicleDao;
import com.dxc.pojos.Vehicle;

public class VehicleService {
	
	VehicleDao dao=new VehicleDao();
	
	public void addVehicle(Vehicle v)
	{
		dao.addVehicle(v);
	}

}
