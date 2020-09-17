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
		return null;
	}

}
