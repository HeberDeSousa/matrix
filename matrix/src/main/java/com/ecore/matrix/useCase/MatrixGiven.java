package com.ecore.matrix.useCase;

import com.ecore.matrix.domain.Matrix;

public class MatrixGiven {

	//Singleton pattern, lazy loaded, threadsafe
	private static volatile MatrixGiven instance = null;

	private MatrixGiven() {
		if (instance != null) {
			throw new RuntimeException("Use getInstance() method to create.");
		}
	}

	public static MatrixGiven getInstance() {
		if (instance == null) {
			synchronized (MatrixGiven.class) {
				if (instance == null) {
					instance = new MatrixGiven();
				}
			}
		}
		return instance;
	}

	public Matrix execute(Matrix matrix) {
		return matrix;
	}

}
