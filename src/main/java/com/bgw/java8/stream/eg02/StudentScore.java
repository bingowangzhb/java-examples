package com.bgw.java8.stream.eg02;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class StudentScore {
    private String studentId;
    private String studentName;
    private String subjectId;
    private String subjectName;
    private Integer score;
}
