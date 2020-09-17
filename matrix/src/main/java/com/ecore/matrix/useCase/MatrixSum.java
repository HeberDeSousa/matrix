package com.ecore.matrix.useCase;

import com.ecore.matrix.domain.Matrix;

public class MatrixSum {

	// Singleton pattern, lazy loaded, threadsafe
	private static volatile MatrixSum instance = null;

	private MatrixSum() {
		if (instance != null) {
			throw new RuntimeException("Use getInstance() method to create.");
		}
	}

	public static MatrixSum getInstance() {
		if (instance == null) {
			synchronized (MatrixSum.class) {
				if (instance == null) {
					instance = new MatrixSum();
				}
			}
		}
		return instance;
	}

	public Integer execute(Matrix matrix) {
		Integer[][] intMatrix = matrix.toIntMatrix();
		Integer sum = 0;
		for (int i = 0; i < intMatrix.length; i++) {
			for (int j = 0; j < intMatrix[i].length; j++) {
				sum += intMatrix[i][j];
			}
		}
		return sum;
	}

}
