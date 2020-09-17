package com.ecore.matrix;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

	@Test
	void testGiven() {
		String[] matrixCsv = { "1,2,3", "4,5,6", "7,8,9" };
		Matrix matrix2 = new Matrix(matrixCsv);
		assertTrue(matrix.equals(matrix2));
	}

	@Test
	void testInvert() {
		String[] invertedMatrixCsv = { "1,4,7", "2,5,8", "3,6,9" };
		Matrix invertedMatrix = new Matrix(invertedMatrixCsv);
		assertTrue(invertedMatrix.equals(invertOperation.execute(matrix)));
	}

	@Test
	void testFlatten() {
		String flattened = "1,2,3,4,5,6,7,8,9";
		assertEquals(flattened, flattenOperation.execute(matrix));
	}

	@Test
	void testSum() {
		Integer sum = 45;
		assertEquals(sum, sumOperation.execute(matrix));
	}

	@Test
	void testMultiply() {
		Integer multiplication = 362880;
		assertEquals(multiplication, multiplyOperation.execute(matrix));
	}

}
