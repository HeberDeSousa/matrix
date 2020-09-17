package com.ecore.matrix;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.ecore.matrix.domain.Matrix;

@SpringBootTest
class MatrixApplicationTests {

	Matrix matrix = new Matrix();
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
