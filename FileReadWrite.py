import json
import csv
from constants import Constants


class FileReadWrite:
    def writeData(self, validSet, invalidSet, naSet):
        self.writeToFile("./output/valid.csv", validSet)
        self.writeToFile("./output/invalid.csv", invalidSet)
        self.writeToFile("./output/na.csv", naSet)

    def writeToFile(self, filename, data):
        file = open(filename, "a", newline="")
        # writing the data into the file
        with file:
            write = csv.writer(file)
            write.writerows(data)
        file.close()

    def readData(self):
        with open(Constants.getDataPath()) as file:
            data = json.load(file)

        file.close()
        return (data["response"]["numFound"], data["response"]["docs"])
