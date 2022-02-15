package com.revature.ToDoSpring.beans.controllers;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.ToDoSpring.beans.models.ActionItem;
import com.revature.ToDoSpring.beans.repositories.ActionItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/actionItems")
public class ActionItemController {
    public ActionItemRepository repo;

    @Autowired
    public ActionItemController(ActionItemRepository repo) {
        this.repo = repo;
    }

    @RequestMapping(value = "/{actionItemId}", method = RequestMethod.GET)
    public @ResponseBody ActionItem getActionItemById(@PathVariable Integer actionItemId) {
        return repo.getById(actionItemId);
    }

}
