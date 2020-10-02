package admin.dao;
import java.util.List;

import admin.model.Exam;
import admin.model.Question;
import admin.model.QuestionType;

public interface AdminDao {
   public List<Exam> getAll();
   public int saveQuestion(Question question);
   public int saveQuestionType(QuestionType questionType);
}
