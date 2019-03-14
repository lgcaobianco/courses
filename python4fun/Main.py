import pandas as pd
import numpy as np
import ParaconsistentAnalysis as pa
import ScientificMethods as sm
import queryAndFilter as qa
import pywt


class Main:
    def __init__(self):
        print("Hi, I'm the constructor method")

    def main():
        transform = np.asarray(qa.applyDaubechiesSupport(3))
        print(transform[0])
        print(len(transform))


Main.main()
