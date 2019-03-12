import numpy as np


class DecomposicaoParImpar:
    vetorEntrada = []
    vetorInvertido = []

    def __init__(self, vetorEntrada):
        self.vetorEntrada = np.array(vetorEntrada)
        self.vetorInvertido = np.flip(vetorEntrada)

    def printVetorEntrada(self):
        print(self.vetorEntrada)

    def decomporPar(self):
        return ((0.5 * self.vetorEntrada) + (0.5 * self.vetorInvertido))

    def decomporImpar(self):
        return ((0.5 * self.vetorEntrada) - (0.5 * self.vetorInvertido))

    def testarDecomposicaoParImpar(self):
        print(self.decomporPar())
        print(self.decomporImpar())
