import numpy as np
import csv
import pandas as pd


class ParaconsistentAnalysis:
    nClasses = int()
    isnormalized = False  # normalization is assumed to be true
    names = []
    columns = []
    dataset = pd.DataFrame()
    maxs = [[], []]
    mins = [[], []]
    alpha = float()
    beta = float()
    g1 = float()
    g2 = float()

    def __init__(self, dataframe_of_signals, readFromFile):
        # number of classes in the dataset
        self.nClasses = 5
        # length of classes in the dataset
        self.lengthOfClasses = [20, 20, 20, 20, 20]
        if(readFromFile):
            nameFile = 'dataset/dataset4.csv'
            if ('.csv' not in nameFile):
                nameFile += ".csv"
            self.dataset = []
            with open(nameFile, newline='') as csvfile:
                reader = csv.reader(csvfile, delimiter=',')
                for row in reader:
                    temp = np.array(row)
                    self.dataset.append(temp)
            self.names = [i for i in range(0, len(self.dataset[0]), 1)]
            names = self.names
            for i in range(0, len(self.dataset[0]), 1):
                names[i] = str('column'+str(i))
            self.dataset = pd.DataFrame(
                self.dataset, columns=names, dtype=float)
            if(not self.isnormalized):
                for i in range(0, len(names)):
                    c = str('column' + str(i))
                    self.dataset[c] = self.dataset[c].add(min(self.dataset[c]))
                    self.dataset[c] = self.dataset[c].div(max(self.dataset[c]))
        else:
            self.dataset = pd.DataFrame(dataframe_of_signals)

    def findalpha(self):
        self.mins = np.zeros((self.nClasses, len(self.names)))
        self.maxs = np.zeros((self.nClasses, len(self.names)))
        sims = np.zeros((self.nClasses, len(self.names)))
        for i in range(0, self.nClasses):
            temp = self.dataset.iloc[self.lengthOfClasses[i] *
                                     i:(self.lengthOfClasses[i]*i)+self.lengthOfClasses[i]]
            for j in range(0, len(self.names)):
                self.mins[i][j] = min(temp[self.names[j]])
                self.maxs[i][j] = max(temp[self.names[j]])
        sims = 1 - self.maxs + self.mins
        avg = np.average(sims[0])
        for i in range(1, len(sims)):
            if(avg > np.average(sims[i])):
                avg = np.average(sims[i])
        self.alpha = avg

    def findbeta(self):
        for i in range(0, self.nClasses-1):
            overlap = int()
            for dimension in range(0, len(self.dataset.columns)):
                temp = np.asarray(self.dataset.iloc[(
                    i+1) * self.lengthOfClasses[i+1]: len(self.dataset), :])
                for j in range(0, len(temp)):
                    if(temp[j, dimension] >= self.mins[i][dimension] or temp[j, dimension] <= self.maxs[i][dimension]):
                        overlap = overlap + 1
        self.beta = (overlap / (self.nClasses * (self.nClasses - 1) *
                                len(self.dataset.columns) * self.lengthOfClasses[0]))

    def perform_paraconsistent_analysis(self):
        self.findalpha()
        self.findbeta()
        self.g1 = self.alpha - self.beta
        self.g2 = self.alpha + self.beta - 1
        print("G1 coordinate is: " + str(self.g1))
        print("G2 coordinate is: " + str(self.g2))
