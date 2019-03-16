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
                    self.dataset[c] = self.dataset[c].add(
                        min(self.dataset[c]))
                    self.dataset[c] = self.dataset[c].div(
                        max(self.dataset[c]))
        else:
            self.dataset = pd.DataFrame(dataframe_of_signals)

    def findalpha(self):
        dataset = self.dataset
        self.mins = np.zeros((self.nClasses, len(self.dataset.columns)))
        self.maxs = np.zeros((self.nClasses, len(self.dataset.columns)))
        minsOfClasses = list(list())
        maxsOfClasses = list(list())
        listofalphas = list()
        for i in range(0, self.nClasses):
            mins = list()
            maxs = list()
            startOfCrop = int()
            if(i == 0):
                temp = dataset.iloc[0:self.lengthOfClasses[i]]
            else:
                for j in range(0, i):
                    startOfCrop += self.lengthOfClasses[j]
                temp = dataset.iloc[startOfCrop:(
                    startOfCrop+self.lengthOfClasses[i])]
            for j in range(0, len(dataset.columns)):
                onlyColumns = dataset.iloc[:, j]
                mins.append(min(onlyColumns))
                maxs.append(max(onlyColumns))
            similarities = 1 - np.asarray(maxs) + np.asarray(mins)
            listofalphas.append(similarities.mean())
        self.alpha = min(listofalphas)
        print("alpha is: "+str(self.alpha))

    def findbeta(self):
        dataset = self.dataset
        lengthOfClasses = self.lengthOfClasses
        for i in range(0, self.nClasses-1):
            temp = dataset.iloc[i*lengthOfClasses[i]:i *
                                lengthOfClasses[i]+lengthOfClasses[i], :]
            temp2 = dataset.iloc[i*lengthOfClasses[i] +
                                 lengthOfClasses[i]:len(dataset), :]
            print("temp is:")
            print(temp)
            print("temp2 is:")
            print(temp2)

    def perform_paraconsistent_analysis(self):
        self.findalpha()
        self.findbeta()
        self.g1 = self.alpha - self.beta
        self.g2 = self.alpha + self.beta - 1
        print("G1 coordinate is: " + str(self.g1))
        print("G2 coordinate is: " + str(self.g2))
