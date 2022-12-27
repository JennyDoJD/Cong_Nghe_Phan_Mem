package com.example.demo.controller;

import com.example.demo.dto.ServiceDTO;
import com.example.demo.model.AttachService;
import com.example.demo.model.Service;

import com.example.demo.model.*;
import com.example.demo.service.IAttachServiceService;
import com.example.demo.service.IServiceService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import java.util.List;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;


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


    @GetMapping("delete")
    public String delete(@RequestParam int service_id, RedirectAttributes redirectAttributes) {
        serviceService.delete(service_id);
        redirectAttributes.addFlashAttribute("mess", "Delete successfully!");
        return "redirect:/camping/listServiceAdmin";

    @GetMapping("")
    public String getList(Model model, @RequestParam(defaultValue = "0") int page,
                          Optional<String> serviceNameSearch, Optional<String> attachServiceIdSearch) {
        String serviceNameSearchValue = "";
        String attachServiceIdSearchValue = "";
        if(serviceNameSearch.isPresent()) {
            serviceNameSearchValue = serviceNameSearch.get();
        }
        if(attachServiceIdSearch.isPresent()) {
            attachServiceIdSearchValue = attachServiceIdSearch.get();
        }
        model.addAttribute("serviceNameSearch", serviceNameSearchValue);
        model.addAttribute("attachServiceIdSearch", attachServiceIdSearchValue);
        Page<Service> services = serviceService.findByAll(PageRequest.of(page, 4), serviceNameSearchValue, attachServiceIdSearchValue);
        model.addAttribute("services", services);
        return "camping/admin/listService";

    @GetMapping("edit")
    public String showEditService(Model model, @RequestParam int service_id) {
        Service service = serviceService.findById(service_id).orElse(null);
        model.addAttribute("serviceDTO", service);
        return "camping/admin/updateService";
    }
}

