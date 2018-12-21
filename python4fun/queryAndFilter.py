
import psycopg2
import pywt
import numpy as np
import time

conn = psycopg2.connect(
    "host = 'localhost' dbname='mestrado' user='gucaobianco' password='10luiz10'")
cursor = conn.cursor()
filteredList = []

start = time.time()
for support in range(1, 39):
    nomeWavelet = "db" + str(support)
    print(nomeWavelet)
    for i in range(1, 121):
        if (i >= 40 and i < 60):
            continue
        else:
            cursor.execute(
                "SELECT y from public.amostra where sinal_id = {0}" .format(i))
            my_array = np.array(cursor.fetchall()).ravel()
            wp = pywt.WaveletPacket(data=my_array, wavelet=nomeWavelet)
            idealDecomposition = int((wp.maxlevel/2) - 1)
            var = [node.data for node in wp.get_level(
                idealDecomposition, 'natural')]
            array_filtrado = np.array(np.asarray(var)).flatten()
            filteredList.append(array_filtrado)
    filteredList = []

end = time.time()

print("fim do loop! tempo de execucao: " + str(end-start) + "s")
