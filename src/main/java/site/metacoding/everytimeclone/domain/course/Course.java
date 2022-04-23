package site.metacoding.everytimeclone.domain.course;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import site.metacoding.everytimeclone.domain.professor.Professor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EntityListeners(AuditingEntityListener.class)
@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 50, nullable = false)
    private String name; // 과목명

    @Column(length = 10, nullable = false)
    private Integer point; // 학점

    @JoinColumn(name = "professorId")
    @ManyToOne
    private Professor professor; // professorId

    @Column(length = 50, nullable = true)
    private String classroom;

    @Column(length = 10, nullable = false)
    private String weekday;

    @Column(length = 10, nullable = false)
    private Integer startTime;

    @Column(length = 10, nullable = false)
    private Integer endTime;

    @CreatedDate
    private LocalDateTime createDate;
    @LastModifiedBy
    private LocalDateTime updateDate;
}
