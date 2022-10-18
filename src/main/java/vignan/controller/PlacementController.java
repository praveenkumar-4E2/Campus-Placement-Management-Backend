package vignan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import vignan.model.Placement;
import vignan.service.PlacementService;

@CrossOrigin("http://localhost:4200")
@RestController
public class PlacementController {
	@Autowired
	PlacementService placementService;
	
	@PostMapping("placement")
	public Placement addPlacement(@RequestBody Placement placement) {
		return placementService.addPlacement(placement);
	}
	@PutMapping("placement/{rollNo}")
	public Placement addPlacementStudent(@PathVariable String rollNo,@RequestBody Placement placement) {
		return placementService.updatePlacement(rollNo,placement);
	}
	
	@GetMapping("placement")
	public List<Placement> get(){
		return placementService.getAll();
	}
	
	@DeleteMapping("placement/{id}")
	public String deletePlacement(@PathVariable int id) { 
		return placementService.deletePlacement(id);
	}
}
