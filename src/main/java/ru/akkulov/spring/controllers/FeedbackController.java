package ru.akkulov.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.akkulov.model.Feedback;
import ru.akkulov.service.FeedbackService;

import java.util.List;

@Controller
@RequestMapping("/feedback")
public class FeedbackController {
    private final FeedbackService feedbackService;

    @Autowired
    public FeedbackController(FeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }

    @GetMapping
    public String getFeedback(Model model) {
        List<Feedback> feedbackList = feedbackService.getAll();

        model.addAttribute("feedbackList", feedbackList);
        model.addAttribute("newFeedback", new Feedback());
        model.addAttribute("deleteFeedback", new Feedback());
        model.addAttribute("updateFeedback", new Feedback());
        model.addAttribute("getById", new Feedback());

        return "feedback";
    }

    @PostMapping("/create")
    public String newFeedback(@ModelAttribute("newFeedback") Feedback feedback) {
        feedbackService.create(feedback);
        return "redirect:/feedback";
    }

    @PostMapping("/delete")
    public String deleteEmployee(@ModelAttribute("deleteEmployee") Feedback feedback) {
        feedbackService.deleteOne(feedback.getId());
        return "redirect:/feedback";
    }

    @PostMapping("/update")
    public String updateFeedback(@ModelAttribute("updateFeedback") Feedback feedback) {
        feedbackService.updateOne(feedback, feedback.getId());
        return "redirect:/feedback";
    }

    @GetMapping("/get")
    public String getById(@ModelAttribute("getById") Feedback feedback, Model model) {
        model.addAttribute("get_by_id", feedbackService.getById(feedback.getId()));
        return "feedback_get_by_id";
    }
}
