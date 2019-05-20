import psycopg2
import pywt
import numpy as np
import time
import math
from DecomposicaoParImpar import DecomposicaoParImpar


class QueryAndFilter:
    idealDecomposition = int()

    def conectarBanco(self):
        conn = psycopg2.connect(
            "host = 'localhost' dbname='mestrado' user='gucaobianco' password='10luiz10'")
        cursor = conn.cursor()
        return cursor

    def applyDaubechiesSupport(self, support):
        cursor = self.conectarBanco()
        nomeWavelet = "db" + str(support)
        filteredList = []
        print(nomeWavelet)
        for i in range(1, 121):
            if (i >= 40 and i < 60):
                continue
            else:
                cursor.execute(
                    "SELECT y from public.amostra where sinal_id = {0}" .format(i))
                my_array = np.array(cursor.fetchall()).ravel()
                wp = pywt.WaveletPacket(
                    data=my_array, wavelet=nomeWavelet, mode='symmetric')
                self.idealDecomposition = int(
                    math.log(len(my_array))/math.log(2)/2)-1
                var = [node.data for node in wp.get_level(
                    self.idealDecomposition, 'natural')]
                filteredList.append(var)
        return filteredList
