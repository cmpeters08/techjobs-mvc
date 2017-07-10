package org.launchcode.controllers;

import org.launchcode.models.JobData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by LaunchCode
 */
@Controller
@RequestMapping("search")
public class SearchController {

    @RequestMapping(value = "")
    public String search(Model model) {
        model.addAttribute("columns", ListController.columnChoices);
        return "search";
    }

    //requestmapping is the route to the file to use for the handler
    @RequestMapping(value = "/results", method = RequestMethod.GET)
    public String results(Model model,
                          @RequestParam String searchType, @RequestParam String searchTerm){

        if(searchType.equals("all")) {
            ArrayList<HashMap<String, String>> jobs = JobData.findByValue(searchTerm);
            model.addAttribute("columns", ListController.columnChoices);
            model.addAttribute("searchType", searchType);
            model.addAttribute("searchTerm", searchTerm);
            model.addAttribute("jobs", jobs);
        }
        else{
            ArrayList<HashMap<String,String>> jobs = JobData.findByColumnAndValue(searchType, searchTerm);
            model.addAttribute("columns", ListController.columnChoices);
            model.addAttribute("searchType", searchType);
            model.addAttribute("searchTerm", searchTerm);
            model.addAttribute("jobs", jobs);
        }
        return "search";
        //returns search.html

    }



    // TODO #1 - Create handler to process search request and display results



}
