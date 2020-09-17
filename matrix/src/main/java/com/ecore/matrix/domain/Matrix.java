package com.ecore.matrix.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Matrix {

	private String[] matrixCsv;

	public Integer[][] toIntMatrix() {
		if (this.matrixCsv.equals(null) || this.matrixCsv.length == 0) {
			return null;
		}
		Integer[][] intMatrix = new Integer[this.matrixCsv.length][this.matrixCsv[0].replace(",", "").trim().length()];
		int lineNumber = 0;
		for (String line : this.matrixCsv) {
			int colNumber = 0;
			for (int i = 0; i < line.length(); i++) {
				if (Character.isDigit(line.charAt(i))) {
					intMatrix[lineNumber][colNumber] = Integer.parseInt(line.substring(i, i + 1));
					colNumber++;
				}
			}
			lineNumber++;
		}
		return intMatrix;
	}

}
