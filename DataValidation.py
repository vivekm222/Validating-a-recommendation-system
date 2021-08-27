import json
from os import error
import requests
import urllib
from constants import Constants
from FileReadWrite import FileReadWrite


class DataValidation:
    def __init__(self):
        self.FileReadWrite = FileReadWrite()

        self.totalData = None
        self.numItems = None
        self.parsedData = {}
        self.validSet = []
        self.invalidSet = []
        self.naSet = []

        self.numItems, self.totalData = self.FileReadWrite.readData()
        self.parseData()
        self.processData()
        self.FileReadWrite.writeData(self.validSet, self.invalidSet, self.naSet)

    def getRequestData(self, i):
        name = self.totalData[i][Constants.getNameKey()]
        sku_s = self.totalData[i][Constants.getSkuKey()]
        encoded_name = urllib.parse.quote_plus(name)
        url = Constants.getUrl(encoded_name, sku_s)
        response = requests.get(url)
        print("api response for ", name, "->", response.status_code)
        resText = json.loads(response.text)
        return (name, sku_s, url, resText)

    def productValidation(
        self, productRec, productRecRank, name, sku_s, url, resProductName
    ):
        prodIndex = -1
        for product in range(len(productRec)):
            if (
                self.parsedData[productRec[product]]["stock_d"] > 0
                and productRecRank[product] > 7
            ):
                prodIndex = product
                break
        if prodIndex == -1:
            self.naSet.append([name, sku_s, url])
            print("not applicable set")
            return
        if productRec[prodIndex].strip() == resProductName.strip():
            self.validSet.append([name, sku_s, url])
            print("Valid Set")
            return
        else:
            self.invalidSet.append([name, sku_s, url])
            print("Invalid Set")
            return

    def parseData(self):
        for i in range(self.numItems):
            name = self.totalData[i]["name_s"]
            self.parsedData[name] = self.totalData[i]

    def validateData(self, resText, name, sku_s, url, i):

        if Constants.getCrossSellKey() in self.totalData[i]:
            productRec = self.totalData[i][Constants.getCrossSellKey()]
            productRecRank = self.totalData[i][Constants.getCrossSellRankKey()]

            resNumRec = len(resText["products"])
            # if api returns zero products
            if resNumRec == 0:
                self.invalidSet.append([name, sku_s, url])
                print("invalid set 1")
                return
                
            resProducts = resText["products"]
            resProductName = ""
            for k in range(resNumRec):
                tempName = resProducts[k]["name"]
                # check if name from api response is in cross sell rec
                if tempName in productRec:
                    resProductName = tempName
                    break
            # get what the widget should actually reccommend - get the best possible reccommendation from crossSell items
            self.productValidation(
                productRec, productRecRank, name, sku_s, url, resProductName
            )
        else:
            self.naSet.append([name, sku_s, url])
            print("not applicable set")
            return

    def processData(self):
        for i in range(self.numItems):
            if i == 30:
                break
            try:
                print("Parsing ", i, " out of ", self.numItems)
                (name, sku_s, url, resText) = self.getRequestData(i)
                # checking the visibility for the current product. If it is false, then it is considered valid and added to valid bucket
                # Else, we continue with general validation.
                if not self.totalData[i][Constants.getVisibilityKey()]:
                    self.validSet.append([name, sku_s, url])
                    print("Valid Set")
                    continue
                self.validateData(resText, name, sku_s, url, i)
            except Exception as error:
                print(error)
                continue
