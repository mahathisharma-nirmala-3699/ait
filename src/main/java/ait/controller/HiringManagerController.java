package ait.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ait.model.HiringManager;
import ait.repository.HiringManagerRepository;

@RestController
@RequestMapping("/api/hiringManagers")
public class HiringManagerController {
	
	@Autowired
	public HiringManagerRepository hiringManagerRepository; 
	
	@PostMapping
	public HiringManager saveHiringManager(@RequestBody HiringManager hiringManager) {
	return hiringManagerRepository.save(hiringManager);
	}
	
	@GetMapping
	public List<HiringManager> getHiringManagers()
	{
		return hiringManagerRepository.findAll();
	}
	
	 public HiringManager findOrCreateByName(String name) {
	        Optional<HiringManager> optionalHiringManager = hiringManagerRepository.findByName(name);

	        return optionalHiringManager.orElseGet(() -> {
	            HiringManager newHiringManager = new HiringManager(name," "," "," ");
	            return hiringManagerRepository.save(newHiringManager);
	        });
	    }

}
