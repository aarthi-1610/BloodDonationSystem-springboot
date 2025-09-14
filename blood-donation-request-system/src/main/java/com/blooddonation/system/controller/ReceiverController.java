package com.blooddonation.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.blooddonation.system.entity.Receiver;
import com.blooddonation.system.service.ReceiverService;

@Controller
@RequestMapping("/receivers")
public class ReceiverController {

    @Autowired
    private ReceiverService receiverService;

    // Show request form
    @GetMapping("/new")
    public String showRequestForm(Model model) {
        model.addAttribute("receiver", new Receiver());
        return "receiver_form";
    }

    // Submit form
    @PostMapping("/save")
    public String saveReceiver(@ModelAttribute("receiver") Receiver receiver, Model model) {
        String message = receiverService.requestBlood(receiver);
        model.addAttribute("msg", message);
        return "receiver_result";
    }

    // (Optional) view saved requests later
    // @GetMapping
    // public String listReceivers(Model model) {
    //     model.addAttribute("receivers", receiverService.getAllReceivers());
    //     return "receivers";
    // }
}
