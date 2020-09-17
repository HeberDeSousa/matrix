package com.ecore.matrix.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
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

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Matrix)) {
			return false;
		}
		Matrix matrix = (Matrix) obj;
		int i = 0;
		for (String line : matrix.getMatrixCsv()) {
			if (!this.getMatrixCsv()[i].equals(line)) {
				return false;
			}
			i++;
		}
		return true;
	}

}
