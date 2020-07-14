package com.dxc.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dxc.pojos.Vehicle;
import com.dxc.services.VehicleService;

@Controller
@RequestMapping("/views/vehicle")
public class VehicleController {
	
	VehicleService service=new VehicleService();
	
	@RequestMapping("/add")
	public String add(@ModelAttribute Vehicle v, Model m)
	{
		service.addVehicle(v);
		String msg;
		msg="vehicle added !";
		m.addAttribute("msg", msg);
		return "message";
	}
	
	
	@RequestMapping("/show")
	public String getAllVehicles(Model model)
	{
		List<Vehicle> list=service.getAllVehicles();
		model.addAttribute("list", list);
		return "show";
	}
	
	@RequestMapping("/find")
	public String find(@RequestParam("id") int id, Model m, HttpSession session)
	{
		boolean status=true;
		
		session.setAttribute("id", id);
		
		status=service.findVehicle(id);
		String msg;
		
		
		
		if(status==false)
		{
			msg="vehicle not found !";
			m.addAttribute("msg", msg);
			return "message";
		}
		else 
		{
			return "update2";
		}
	}
	
	@RequestMapping("/update")
	public String updateVehicle(@RequestParam String name, @RequestParam double cost, HttpSession session, Model m)
	{
		int id=(int)session.getAttribute("id");
		Vehicle v=new Vehicle();
		v.setId(id);
		v.setName(name);
		v.setCost(cost);
		service.updateVehicle(v);
		String msg="vehicle updated !";
		m.addAttribute("msg", msg);
		return "message";
	}
	
	
	@RequestMapping("/remove")
	public String removeVehicle(@RequestParam int id, Model m)
	{
		service.removeVehicle(id);
		String msg="vehicle removed !";
		m.addAttribute("msg", msg);
		return "message";
	}

}
