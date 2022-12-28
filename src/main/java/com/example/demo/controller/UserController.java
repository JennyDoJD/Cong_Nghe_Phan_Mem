package com.example.demo.controller;


import com.example.demo.dto.UserDTO;
import com.example.demo.model.Users;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("camping/listUserAdmin")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping( "")
    public String getList(Model model ,@RequestParam Optional<String> message){
        Iterable<Users> list= userRepository.findAll();

        if(message.isPresent()){
            model.addAttribute("message", message.get());
        }

        model.addAttribute("users", list);
        return "camping/admin/listUser";
    }

    @GetMapping(value ={ "create" ,"create/{user_id}"})
    public String showCreateUser(Model model, @PathVariable (name = "user_id",required = false) Optional<Integer> user_id) {

        Users users;
        if(user_id.isPresent()){
            Optional<Users> existedCate = userRepository.findById(user_id.get());

            users= existedCate.isPresent()?existedCate.get(): new Users();
        }else
        {
            users = new Users();
        }
        model.addAttribute("userDTO", new UserDTO());
        return "camping/admin/createUser";
    }


    @PostMapping("saveOrUpdate")
    public String saveOrUpdate(RedirectAttributes attributes , @Validated Users item, BindingResult result,Model model) {

        if (result.hasErrors()){
            model.addAttribute("mess", "Add not successfully!");
            return "camping/admin/listUser";
        }
        userRepository.save(item);
        attributes.addAttribute("mess", "Add successfully!");
        return "redirect:/camping/listUserAdmin";
    }


    @GetMapping("delete/{user_id}")
    public String delete(@PathVariable int user_id, RedirectAttributes attributes) {
        userRepository.deleteById(user_id);
        attributes.addFlashAttribute("mess", "Delete successfully!");
        return "redirect:/camping/listUserAdmin";
    }

}
