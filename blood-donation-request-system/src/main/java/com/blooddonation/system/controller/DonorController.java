package com.blooddonation.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.blooddonation.system.entity.Donor;
import com.blooddonation.system.service.DonorService;

@Controller
public class DonorController {

    @Autowired
    private DonorService donorService;

    @GetMapping("/donors")
    public String listDonors(Model model) {
        model.addAttribute("donors", donorService.getAllDonors());
        return "donors";
    }

    @GetMapping("/donors/new")
    public String createDonorForm(Model model) {
        model.addAttribute("donor", new Donor());
        return "create_donor";
    }

    @PostMapping("/donors")
    public String saveDonor(@ModelAttribute("donor") Donor donor) {
        donorService.saveDonor(donor);
        return "redirect:/donors";
    }

    // 👉 EDIT (open form)
    @GetMapping("/donors/edit/{id}")
    public String editDonorForm(@PathVariable Long id, Model model) {
        model.addAttribute("donor", donorService.getDonorById(id));
        return "edit_donor"; // must exist in templates
    }

    // 👉 UPDATE (submit form)
    @PostMapping("/donors/update/{id}")
    public String updateDonor(@PathVariable Long id,
                              @ModelAttribute("donors") Donor donor) {
        donorService.updateDonor(id, donor);
        return "redirect:/donors";
    }

    // 👉 DELETE
    @GetMapping("/donors/delete/{id}")
    public String deleteDonor(@PathVariable Long id) {
        donorService.deleteDonorById(id);
        return "redirect:/donors";
    }
}
