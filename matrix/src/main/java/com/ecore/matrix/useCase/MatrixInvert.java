package com.ecore.matrix.useCase;

import com.ecore.matrix.domain.Matrix;

public class MatrixInvert {
	
	//Singleton pattern, lazy loaded, threadsafe
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
		return null;
	}

}
