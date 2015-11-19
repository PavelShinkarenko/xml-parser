package ru.task.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import ru.task.service.XMLService;

import java.io.File;

@Controller
public class XMLController {
    private XMLService xmlService;

    @Autowired
    public void setXmlService(XMLService xmlService) {
        this.xmlService = xmlService;
    }

    @RequestMapping("/")
    public String home() {
        return "redirect:/catalog";
    }

    @RequestMapping(value = "/catalog", method = RequestMethod.GET)
    public String showCatalog(Model model) {
        model.addAttribute("cd", xmlService.getCdListFromServer());
        return "catalog";
    }

    @RequestMapping(value = "/upload")
    public String uploadPage() {
        return "upload";
    }

    @RequestMapping(value = "/uploading", method = RequestMethod.POST)
    public String uploading(@RequestParam("file") MultipartFile multipartFile) {
        xmlService.upload(multipartFile);
        return "redirect:/catalog";
    }

    @RequestMapping(value = "/downloading", method = RequestMethod.GET)
    @ResponseBody
    public FileSystemResource getFile() {
        return xmlService.getFile();
    }

}
