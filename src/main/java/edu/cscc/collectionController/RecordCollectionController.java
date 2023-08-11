package edu.cscc.collectionController;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import edu.cscc.model.VinylRecord;
import edu.cscc.repository.RecordCollectionRepository;

@Controller
public class RecordCollectionController {
	@Autowired
	private RecordCollectionRepository repository;
	
	@GetMapping("/add-record")
	public String getRecordForm(Model model) {
		long count = repository.count();
		model.addAttribute("count", count);
		model.addAttribute("request", new VinylRecord());
		
		return "add-record";
	}
	
	@PostMapping("/records")
	public String postRecord(@Valid @ModelAttribute("request") VinylRecord record, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "add-record";
		}
		var createdRecord = repository.save(record);
		return "redirect:/records/" + createdRecord.id;
	}
	
	@GetMapping("/records")
	public String getRecords(Model model) {
		long count = repository.count();
		
		var records = repository.findAll();

		model.addAttribute("count", count);
		model.addAttribute("records", records);
		
		return "records";
	}
	
	@GetMapping("/records/{id}")
	public String getRecord(@PathVariable long id, Model model) {
		var record = repository.findById(id).get();
		
		model.addAttribute("title", record.title);
		model.addAttribute("artist", record.artist);
		model.addAttribute("label", record.label);
		model.addAttribute("releaseYear", record.releaseYear);
		model.addAttribute("numTracks", record.numTracks);
		model.addAttribute("size", record.size);
		model.addAttribute("isDamaged", record.isDamaged);
		
		return "record";
		
	}
	
}

