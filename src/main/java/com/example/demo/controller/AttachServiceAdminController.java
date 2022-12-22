package com.example.demo.controller;

import com.example.demo.model.AttachService;
import com.example.demo.service.IAttachServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("camping/listAttachServiceAdmin")
public class AttachServiceAdminController {
    @Autowired
    IAttachServiceService iAttachServiceService;


    @GetMapping("edit")
    public String showEditAttachService(Model model, @RequestParam int attach_service_id) {
        AttachService attachService = iAttachServiceService.findById(attach_service_id).orElse(null);
        model.addAttribute("attachServiceDTO", attachService);
        return "camping/admin/updateAttachService";
    }

}
