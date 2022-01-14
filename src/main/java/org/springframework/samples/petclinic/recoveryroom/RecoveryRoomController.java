package org.springframework.samples.petclinic.recoveryroom;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.pet.Pet;
import org.springframework.samples.petclinic.pet.PetType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RecoveryRoomController {
    
	private static final String VIEWS_RECOVERYROOM_CREATE_OR_UPDATE_FORM = "recoveryroom/createOrUpdateRecoveryRoomForm";
	
	@Autowired
	RecoveryRoomService recoveryroomservice;
	
	@ModelAttribute("types")
	public Collection<RecoveryRoomType> populateRecoveryRoomTypes() {
		return this.recoveryroomservice.getAllRecoveryRoomTypes();
	}
	
	@GetMapping(value="/recoveryroom/create")
	public String initCreationForm(ModelMap model) {
		
		RecoveryRoom recoveryroom=new RecoveryRoom();
		model.put("recoveryRoom", recoveryroom);
		return VIEWS_RECOVERYROOM_CREATE_OR_UPDATE_FORM;
	}
	
	@PostMapping(value="/recoveryroom/create")
	public String processCreationForm(@Valid RecoveryRoom recoveryroom, BindingResult result, ModelMap model) {
		String view="welcome";
		if(result.hasErrors()){
			model.put("recoveryRoom", recoveryroom);
			return VIEWS_RECOVERYROOM_CREATE_OR_UPDATE_FORM;
		}else {
			this.recoveryroomservice.save(recoveryroom);
		}
		
		return view;
	}
}
