package ru.akkulov.service;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.akkulov.dao.FeedbackDAO;
import ru.akkulov.model.Feedback;

import java.util.List;

@Data
@Component
public class FeedbackService {
    private FeedbackDAO feedbackDAO;

    @Autowired
    public FeedbackService(FeedbackDAO feedbackDAO) {
        this.feedbackDAO = feedbackDAO;
    }

    public FeedbackService() {
        this.feedbackDAO = new FeedbackDAO();
    }

    public void create(Feedback feedback) {
        feedbackDAO.create(feedback);
    }

    public List<Feedback> getAll() {
        return feedbackDAO.readAll();
    }

    public Feedback getById(int id) {
        return feedbackDAO.getById(id);
    }

    public void updateOne(Feedback feedback, int id) {
        feedbackDAO.updateOne(feedback, id);
    }

    public void deleteOne(int id) {
        feedbackDAO.deleteOne(id);
    }
}
