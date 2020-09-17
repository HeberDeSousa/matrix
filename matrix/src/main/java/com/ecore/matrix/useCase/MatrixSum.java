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
		return null;
	}

}
