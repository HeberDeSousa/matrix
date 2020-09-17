package com.ecore.matrix.useCase;

import com.ecore.matrix.domain.Matrix;

public class MatrixInvert {

	// Singleton pattern, lazy loaded, threadsafe
	private static volatile MatrixInvert instance = null;

	private MatrixInvert() {
		if (instance != null) {
			throw new RuntimeException("Use getInstance() method to create.");
		}
	}

	public static MatrixInvert getInstance() {
		if (instance == null) {
			synchronized (MatrixInvert.class) {
				if (instance == null) {
					instance = new MatrixInvert();
				}
			}
		}
		return instance;
	}

	public Matrix execute(Matrix matrix) {
		Integer[][] intMatrix = matrix.toIntMatrix();
		Integer[][] invertedIntMatrix = new Integer[intMatrix[0].length][intMatrix.length];
		for (int i = 0; i < intMatrix.length; i++) {
			for (int j = 0; j < intMatrix[i].length; j++) {
				invertedIntMatrix[j][i] = intMatrix[i][j];
			}
		}
		String[] invertedMatrixCsv = new String[invertedIntMatrix.length];
		for (int i = 0; i < invertedIntMatrix.length; i++) {
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < invertedIntMatrix[i].length; j++) {
				sb.append(invertedIntMatrix[i][j]);
				if (j + 1 < invertedIntMatrix[i].length) {
					sb.append(",");
				}
			}
			invertedMatrixCsv[i] = sb.toString();
		}
		return new Matrix(invertedMatrixCsv);
	}

}
