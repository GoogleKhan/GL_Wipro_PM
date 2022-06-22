package com.wipro.firstapp.model;

import lombok.Builder;
import lombok.Data;

//Equivalent to { @Getter @Setter @RequiredArgsConstructor @ToString @EqualsAndHashCode}
@Data

@Builder
public class GreatLearning {

	private String courseName;
	private String courseType;
	private String instructorName;

//	public GreatLearning() {
//	}
//
//	public GreatLearning(String courseName) {
//		this.courseName = courseName;
//	}
//
//	public GreatLearning(String courseName, String courseType) {
//		this.courseName = courseName;
//		this.courseType = courseType;
//	}
//
//	public GreatLearning(String courseName, String courseType, String instructorName) {
//		this.courseName = courseName;
//		this.courseType = courseType;
//		this.instructorName = instructorName;
//	}

}
