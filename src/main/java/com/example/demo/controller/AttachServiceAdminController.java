package com.example.demo.controller;

import com.example.demo.dto.AttachServiceDTO;
import com.example.demo.dto.ServiceDTO;
import com.example.demo.model.AttachService;
import com.example.demo.model.Service;
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

}
