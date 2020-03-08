package org.example.controller;

import org.example.model.Item;
import org.example.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
public class ItemController {

    private ItemService service;

    @Autowired
    public ItemController(ItemService service) {
        this.service = service;
    }

    @RequestMapping("/")
    public ModelAndView home() {
        List<Item> itemList = service.getList();
        ModelAndView view = new ModelAndView("index");
        view.addObject("itemList", itemList);
        return view;
    }

    @RequestMapping("/addItem")
    public String getCustomerForm(Map<String, Object> model) {
        Item item = new Item();
        model.put("item", item);
        return "addItem";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String addItem(@ModelAttribute("item") Item item) {
        service.add(item);
        return "redirect:/";
    }

    @RequestMapping("/edit")
    public ModelAndView editItem(@RequestParam Long id) {
        ModelAndView view = new ModelAndView("editItem");
        Item item = service.getById(id);
        view.addObject("item", item);
        return view;
    }

    @RequestMapping("/delete")
    public String deleteItem(@RequestParam Long id) {
        service.deleteById(id);
        return "redirect:/";
    }





}
