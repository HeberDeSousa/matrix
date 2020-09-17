package com.ecore.matrix.useCase;

import com.ecore.matrix.domain.Matrix;

public class MatrixMultiply {

	// Singleton pattern, lazy loaded, threadsafe
	private static volatile MatrixMultiply instance = null;

	private MatrixMultiply() {
		if (instance != null) {
			throw new RuntimeException("Use getInstance() method to create.");
		}
	}

	public static MatrixMultiply getInstance() {
		if (instance == null) {
			synchronized (MatrixMultiply.class) {
				if (instance == null) {
					instance = new MatrixMultiply();
				}
			}
		}
		return instance;
	}

	public Integer execute(Matrix matrix) {
		Integer[][] intMatrix = matrix.toIntMatrix();
		Integer multiplication = 1;
		for (int i = 0; i < intMatrix.length; i++) {
			for (int j = 0; j < intMatrix[i].length; j++) {
				multiplication *= intMatrix[i][j];
			}
		}
		return multiplication;
	}

}
