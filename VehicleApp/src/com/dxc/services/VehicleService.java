package com.dxc.services;

import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import com.dxc.daos.VehicleDao;
import com.dxc.pojos.Vehicle;

public class VehicleService {
	
	VehicleDao dao=new VehicleDao();
	
	public void addVehicle(Vehicle v)
	{
		dao.addVehicle(v);
	}
	
	public List<Vehicle> getAllVehicles()
	{
		return dao.getAllVehicles();
	}
	
	public boolean findVehicle(int id) {
		return dao.findVehicle(id);
	}
	
	public void updateVehicle(Vehicle v)
	{
		dao.updateVehicle(v);
	}
	
	public void removeVehicle(int id)
	{
		dao.removeVehicle(id);
	}

}
