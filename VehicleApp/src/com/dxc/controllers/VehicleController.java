package com.dxc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dxc.pojos.Vehicle;
import com.dxc.services.VehicleService;

@Controller
@RequestMapping("/vehicle")
public class VehicleController {
	
	VehicleService service=new VehicleService();
	
	@RequestMapping("/add")
	public String add(@ModelAttribute Vehicle v)
	{
		service.addVehicle(v);
		return "message";
	}

}
