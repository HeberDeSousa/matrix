package com.ecore.matrix.useCase;

import com.ecore.matrix.domain.Matrix;

public class MatrixFlatten {

	// Singleton pattern, lazy loaded, threadsafe
	private static volatile MatrixFlatten instance = null;

	private MatrixFlatten() {
		if (instance != null) {
			throw new RuntimeException("Use getInstance() method to create.");
		}
	}

	public static MatrixFlatten getInstance() {
		if (instance == null) {
			synchronized (MatrixFlatten.class) {
				if (instance == null) {
					instance = new MatrixFlatten();
				}
			}
		}
		return instance;
	}

	public String execute(Matrix matrix) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < matrix.getMatrixCsv().length; i++) {
			sb.append(matrix.getMatrixCsv()[i]);
			if (i + i < matrix.getMatrixCsv().length) {
				sb.append(",");
			}
		}
		return sb.toString();
	}

}
