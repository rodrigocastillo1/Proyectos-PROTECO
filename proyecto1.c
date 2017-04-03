//AUTOR: Rodrigo Castillo Alcántara. Prebecario 11
/* Para mandar parámetros al programa se envía cada matríz entrecomillada a la terminal y con sus elementos separados por espacios
	ejemplo: 	>> ./proyecto1 "1 2 3 4" "5 6 7 8"
*/

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void matMultiplier(int *mat1, float *mat2, double fmat[][4]);			//Función para multiplicar matrices
void matGen(char *arrays[], int *mat4x1, float *mat1x4);				//Función para generar matrices a partir de los datos pasados desde consola
void printMatrix(double fmat[][4]);										//Función para imprimir matrices

int main(int argc, char *argv[]){										//MAIN
	int mat4x1[4], i;													//Matríz entera de 4x1
	float mat1x4[4];													//Matríz de tipo float de 1x4
	double fmat[4][4];													//Matríz de tipo double de 4x4
	matGen(argv, mat4x1, mat1x4);											//Se manda a llamar a la función que genera las matrices
	matMultiplier(mat4x1, mat1x4, fmat);									//Se manda a llamar a la función que multiplica a las matrices
	printMatrix(fmat);														//Se manda a llamar a la función que imprime la matriz resultante

	return 0;															//Finaliza el programa
}


void matGen(char *arrays[], int *mat4x1, float *mat1x4){				//Genera las matrices a partir de los arreglos enviados desde la terminal
	int i;																//Variable de iteración

	mat4x1[0] = atoi(strtok(arrays[1], " "));								//Sacamos el primer valor del primer arreglo enviado desde la terminal y lo metemos a la matriz
	for(i=1; i<4; i++){														//Por cada elemento restante en el primer arreglo:
			mat4x1[i] = atoi(strtok(NULL, " "));							//Lo sacamos y se almacena en la matriz de 4x1
	}

	mat1x4[0] = atof(strtok(arrays[2], " "));								//Sacamos el primer valor del segundo arreglo enviado desde la terminal y lo metemos a la matriz
	for(i=1; i<4; i++){														//Por cada elemento restante en el segundo arreglo:
			mat1x4[i] = atof(strtok(NULL, " "));							//Lo sacamos y se almacena en la matriz de 1x4
	}

	return;																//Retornamos a main
}


void matMultiplier(int *mat1, float *mat2, double fmat[][4]){			//Multiplicadora de Matrices
	int i, j;															//Variables de iteración
	for(i=0; i<4; i++){														//Se inicia un ciclo for de 0 a 4 para en este caso particular iterar sobre la primera matríz
		for(j=0; j<4; j++){													//Se inicia otro ciclo for para iterar sobre la segunda matríz
			fmat[i][j] = (double)mat1[i]*(double)mat2[j];					//Se van multiplicando los valores e ingresando a la matriz resultante
		}
	}
	
	return;																//Se retorna a main
}


void printMatrix(double fmat[][4]){										//Impresora de matrices
	int i, j;															//Variables de iteración
	for(i=0; i<4; i++){														//Se inicia un ciclo for para iterar sobres los renglones de la matríz
		printf("[");														//Se imprime un corchete para dar una mejor presentación
		for(j=0; j<4; j++){													//Se abre un segundo ciclo for para iterar sobre las columnas
			printf(" %.2f", fmat[i][j]);									//Se imprime el valor de elemento iterado
		}
		printf(" ]\n");														//Se imprime un corchete final para cerrar el renglón
	}

	return;																//Se retorna a main
}
