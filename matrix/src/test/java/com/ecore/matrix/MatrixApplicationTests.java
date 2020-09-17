package com.ecore.matrix;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.ecore.matrix.domain.Matrix;
import com.ecore.matrix.useCase.MatrixFlatten;
import com.ecore.matrix.useCase.MatrixGiven;
import com.ecore.matrix.useCase.MatrixInvert;
import com.ecore.matrix.useCase.MatrixMultiply;
import com.ecore.matrix.useCase.MatrixSum;

@SpringBootTest
class MatrixApplicationTests {

	Matrix matrix = new Matrix();
	MatrixGiven givenOperation = MatrixGiven.getInstance();
	MatrixInvert invertOperation = MatrixInvert.getInstance();
	MatrixFlatten flattenOperation = MatrixFlatten.getInstance();
	MatrixSum sumOperation = MatrixSum.getInstance();
	MatrixMultiply multiplyOperation = MatrixMultiply.getInstance();
	
	{
		String[] matrixCsv = { "1,2,3", "4,5,6", "7,8,9" };
		matrix.setMatrixCsv(matrixCsv);
	}

	@Test
	void convertCsvToIntMatrix() {
		Integer[][] intMatrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		assertArrayEquals(intMatrix, matrix.toIntMatrix());
	}

}
