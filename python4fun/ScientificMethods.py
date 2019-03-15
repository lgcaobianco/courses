import pandas as pd
import numpy as np
from QueryAndFilter import QueryAndFilter
from ParaconsistentAnalysis import ParaconsistentAnalysis


class ScientificMethods:
    filteredArrays = [[], []]
    idealDecomposition = int()

    def __init__(self, filterSupport):
        qa = QueryAndFilter()
        self.filteredArrays = qa.applyDaubechiesSupport(filterSupport)
        self.idealDecomposition = qa.idealDecomposition
        print("class scientific method has been instantiated.")
        print("ideal decomposition is: "+str(self.idealDecomposition))

    def extractEnergy(self, signals):
        energyMatrix = list(list())
        for signal in signals:
            energyArray = []
            for array in signal:
                summation = float()
                for element in array:
                    summation += element * element
                energyArray.append(summation)
            energyMatrix.append(energyArray)
        normalizedEnergy = list(list())
        for signal in energyMatrix:
            signal /= max(np.asarray(signal))
            normalizedEnergy.append(signal)
        return normalizedEnergy


sm = ScientificMethods(3)
energyMatrix = sm.extractEnergy(sm.filteredArrays)
pa = ParaconsistentAnalysis(energyMatrix, readFromFile=False)
pa.perform_paraconsistent_analysis()
