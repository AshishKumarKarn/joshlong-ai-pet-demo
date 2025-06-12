package com.karn.adoption.mod1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@ResponseBody
@RequestMapping("/adoption/dog")
class DogAdoptionController {
    private final DogAdoptionService dogAdoptionService;

    DogAdoptionController(DogAdoptionService dogAdoptionService) {
        this.dogAdoptionService = dogAdoptionService;
    }

    @PostMapping("/adopt/{id}")
    String adoptDog(@PathVariable int id, @RequestBody Map<String, String> owner) {
        String name = owner.get("name");
        dogAdoptionService.adoptDog(id, name);
        return "Dog adopted successfully!";
    }
}
