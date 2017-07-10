package org.launchcode.controllers;

import org.launchcode.models.JobData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
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
    @RequestMapping(value = "/search")
    public String results(Model model,
                          @RequestParam String searchType, @RequestParam String searchTerm){
        ArrayList<HashMap<String, String>> searchResults = JobData.findByValue(searchTerm);
        model.addAttribute("columns", ListController.columnChoices);
        model.addAttribute("searchType", searchType);
        model.addAttribute("searchTerm", searchTerm);
        model.addAttribute("searchResults", searchResults);
        return "/search/results";

    }



    // TODO #1 - Create handler to process search request and display results



}
