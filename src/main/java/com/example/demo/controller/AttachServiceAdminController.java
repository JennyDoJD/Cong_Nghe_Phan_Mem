package com.example.demo.controller;

import com.example.demo.dto.AttachServiceDTO;
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


    @GetMapping("delete")
    public String delete(@RequestParam int attach_service_id, RedirectAttributes redirectAttributes) {
        iAttachServiceService.delete(attach_service_id);
        redirectAttributes.addFlashAttribute("mess", "Delete successfully!");
        return "redirect:/camping/listAttachServiceAdmin";
    }
}
