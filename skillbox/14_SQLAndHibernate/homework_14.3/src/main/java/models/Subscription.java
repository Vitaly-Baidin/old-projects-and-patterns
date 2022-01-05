package models;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data

@Entity
@Table(name = "Subscriptions")
public class Subscription {

    @EmbeddedId
    private KeySubscriptions id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_id", insertable = false, updatable = false)
    private Student studentId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "course_id", insertable = false, updatable = false)
    private Course courseId;

    @Column(name = "subscription_date")
    private Date subscriptionDate;

}
