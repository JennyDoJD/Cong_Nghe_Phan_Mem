package com.example.demo.controller;

import com.example.demo.dto.AttachServiceDTO;
import com.example.demo.model.AttachService;
import com.example.demo.service.IAttachServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.demo.dto.AttachServiceDTO;
import com.example.demo.dto.ServiceDTO;
import com.example.demo.model.AttachService;
import com.example.demo.model.Service;
import com.example.demo.model.AttachService;
import com.example.demo.service.IAttachServiceService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

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

    @GetMapping("edit")
    public String showEditAttachService(Model model, @RequestParam int attach_service_id) {
        AttachService attachService = iAttachServiceService.findById(attach_service_id).orElse(null);
        model.addAttribute("attachServiceDTO", attachService);
        return "camping/admin/updateAttachService";
    }

    @GetMapping("")
    public String getList(Model model, @RequestParam(defaultValue = "0") int page,
                          Optional<String> attachServiceNameSearch) {
        String attachServiceNameSearchValue = "";
        if(attachServiceNameSearch.isPresent()) {
            attachServiceNameSearchValue = attachServiceNameSearch.get();
        }
        model.addAttribute("attachServiceNameSearch", attachServiceNameSearchValue);
        Page<AttachService> attachServices = iAttachServiceService.findByAll(PageRequest.of(page, 4), attachServiceNameSearchValue);
        model.addAttribute("attachServices", attachServices);
        return "camping/admin/listAttachService";
    }
    
    @GetMapping("delete")
    public String delete(@RequestParam int attach_service_id, RedirectAttributes redirectAttributes) {
        iAttachServiceService.delete(attach_service_id);
        redirectAttributes.addFlashAttribute("mess", "Delete successfully!");
        return "redirect:/camping/listAttachServiceAdmin";
    }
}
