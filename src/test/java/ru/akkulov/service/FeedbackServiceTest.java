package ru.akkulov.service;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.akkulov.model.Feedback;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FeedbackServiceTest {
    private static FeedbackService service;

    @BeforeAll
    static void doBefore() {
        service = new FeedbackService();
    }

    @Test
    void createAndGetAll() {
        List<Feedback> feedbackList = service.getAll();
        int resCount = feedbackList.size() + 1;

        Feedback feedback = new Feedback();
        feedback.setDescription("best");
        feedback.setDate("1.1.1");
        feedback.setEmployee_id(7);

        service.create(feedback);

        feedbackList = service.getAll();

        assertEquals(resCount, feedbackList.size());

        int id = feedbackList.get(feedbackList.size() - 1).getId();
        service.deleteOne(id);
    }


    @Test
    void getById() {
        Feedback feedback = new Feedback();
        feedback.setDescription("best");
        feedback.setDate("1.1.1");
        feedback.setEmployee_id(7);

        service.create(feedback);

        List<Feedback> feedbackList = service.getAll();
        int id = feedbackList.get(feedbackList.size() - 1).getId();
        String description = feedbackList.get(feedbackList.size() - 1).getDescription();

        assertEquals(feedback.getDescription(), description);

        service.deleteOne(id);
    }

    @Test
    void updateOne() {
        Feedback feedback = new Feedback();
        feedback.setDescription("best");
        feedback.setDate("1.1.1");
        feedback.setEmployee_id(7);

        service.create(feedback);

        List<Feedback> feedbackList = service.getAll();

        int id = feedbackList.get(feedbackList.size() - 1).getId();

        feedback.setDescription("AAAAA");
        feedback.setDate("12.10.2021");

        service.updateOne(feedback, id);

        Feedback feedback1 = service.getById(id);

        assertEquals(feedback.getDescription(), feedback1.getDescription());
        assertEquals(feedback.getDate(), feedback1.getDate());

        service.deleteOne(id);
    }

    @Test
    void deleteOne() {
        Feedback feedback = new Feedback();
        feedback.setDescription("best");
        feedback.setDate("1.1.1");
        feedback.setEmployee_id(7);
        service.create(feedback);

        List<Feedback> feedbackList = service.getAll();
        int count = feedbackList.size() - 1;

        service.deleteOne(feedbackList.get(feedbackList.size() - 1).getId());

        feedbackList = service.getAll();

        assertEquals(count, feedbackList.size());
    }
}