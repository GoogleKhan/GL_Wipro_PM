package com.wipro.firstapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;

//Equivalent to { @Getter @Setter @RequiredArgsConstructor @ToString @EqualsAndHashCode}
@Data
@AllArgsConstructor
public class GreatLearning {

	private String courseName;
	private String courseType;
	private String instructorName;

}
