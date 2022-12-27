package com.example.demo.controller;

import com.example.demo.dto.ServiceDTO;
import com.example.demo.model.AttachService;
import com.example.demo.model.Service;
import com.example.demo.service.IAttachServiceService;
import com.example.demo.service.IServiceService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("camping/listServiceAdmin")
public class ServiceAdminController {
    @Autowired
    IServiceService serviceService;

    @Autowired
    IAttachServiceService iAttachServiceService;

    @ModelAttribute("attachServiceList")
    public List<AttachService> attachServiceList() {
        return iAttachServiceService.findAll();
    }

    @GetMapping("create")
    public String showCreateService(Model model) {
        model.addAttribute("serviceDTO", new ServiceDTO());
        return "camping/admin/createService";
    }

    @PostMapping("save")
    public String save(@ModelAttribute @Validated ServiceDTO serviceDTO, BindingResult bindingResult, Model model){
        Service service = new Service();
        if (bindingResult.hasErrors()){
            model.addAttribute("mess", "Add not successfully!");
            return "camping/admin/createService";
        }else {
            BeanUtils.copyProperties(serviceDTO, service);
            serviceService.save(service);
            model.addAttribute("serviceDTO", serviceDTO);
            model.addAttribute("mess", "Add successfully!");
        }
        return "redirect:/camping/listServiceAdmin";
    }
}

