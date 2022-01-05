package models;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@EqualsAndHashCode

@Embeddable
public class KeySubscriptions implements Serializable {

    @Column(name = "student_id")
    private int studentID;

    @Column(name = "course_id")
    private int CourseID;
}
