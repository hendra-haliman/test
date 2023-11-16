package com.tugas.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.data.domain.Page;

import com.tugas.crud.service.UserService;
import com.tugas.crud.model.User;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String home() {
        return "index2";
    }

    @GetMapping("/listUsers/{pageNo}/{pageSize}")
    public String listUsers(Model model, 
            @PathVariable (value="pageNo") int pageNo,
            @PathVariable (value="pageSize") int pageSize) {
       
        Page<User> page = userService.listUsers(pageNo, pageSize);
        List<User> users = page.getContent();

        model.addAttribute("userList", users);
        model.addAttribute("pageNo", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());

        long totalUsers = page.getTotalElements();
        model.addAttribute("totalUsers", totalUsers);
        model.addAttribute("pageSize", pageSize);

        long offset = page.getPageable().getOffset();
        long startItem;
        if (offset + 1 > totalUsers) {
            startItem = totalUsers;
        } else {
            startItem = offset + 1;
        }

        model.addAttribute("startItem", startItem);
        long endItem;
        if ((offset + pageSize) > totalUsers) {
            endItem = totalUsers;
        } else {
            endItem = offset + pageSize;
        }
        model.addAttribute("endItem", endItem);

        return "users";
    }
    
    @GetMapping("addUser")
    public String addUser(Model model) {
        model.addAttribute("user", new User());
        return "add_user";
    }
    
    @PostMapping("saveUser")
    public String saveUser(@ModelAttribute("user") User user, BindingResult errors) {
        userService.addUser(user);
        return "redirect:/listUsers/1/10";
    }
    
    @ResponseBody
    @GetMapping("/deleteUser")
    public String deleteUser(@RequestParam(name = "custId") String custId) {
        userService.deleteUserById(custId);

        return "user deleted.";
    }
    
    
}
