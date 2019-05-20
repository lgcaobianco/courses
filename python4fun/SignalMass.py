import numpy as np
import math


class SignalMass:
    vetorEntrada = []

    def __init__(self, vetorEntrada):
        self.vetorEntrada = np.array(vetorEntrada)

    def calcularMassa(self):
        vetorEntrada = self.vetorEntrada
        print("vetor entrada")
        print(vetorEntrada)
        print("comprimento do vetor entrada" + str(len(self.vetorEntrada)))
        mass = []
        for i in range(0, len(vetorEntrada)):
            if(self.vetorEntrada[i] == 0):
                mass.append(1)
            else:
                z = (vetorEntrada[i-1] + vetorEntrada[i+1]) / \
                    (2 * vetorEntrada[i])
                if(z >= -1 and z <= -1):
                    mass.append(np.sinc(math.acos(z)) * np.sinc(math.acos(z)))
                else:
                    minhaVar = abs(z + math.sqrt((z*z)-1))
                    ((z*z) + (z * math.sqrt((z*z)-1)) - 1) / \
                        (minhaVar * math.log(minhaVar))


sm = SignalMass([2, 3, 4])
sm.calcularMassa()
