package com.example.demo.controller;

import com.example.demo.dto.AttachServiceDTO;
import com.example.demo.model.AttachService;
import com.example.demo.service.IAttachServiceService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("camping/listAttachServiceAdmin")
public class AttachServiceAdminController {
    @Autowired
    IAttachServiceService iAttachServiceService;

    @GetMapping("create")
    public String showCreateAttachService(Model model) {
        model.addAttribute("attachServiceDTO", new AttachServiceDTO());
        return "camping/admin/createAttachService";
    }

    @PostMapping("save")
    public String save(@ModelAttribute @Validated AttachServiceDTO attachServiceDTO, BindingResult bindingResult, Model model){
        AttachService attachService = new AttachService();
        if (bindingResult.hasErrors()){
            model.addAttribute("mess", "Add not successfully!");
            return "camping/admin/listAttachService";
        }else {
            BeanUtils.copyProperties(attachServiceDTO, attachService);
            iAttachServiceService.save(attachService);
            model.addAttribute("attachServiceDTO", attachServiceDTO);
            model.addAttribute("mess", "Add successfully!");
        }
        return "redirect:/camping/listAttachServiceAdmin";
    }



}
