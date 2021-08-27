from decouple import config


class Constants:
    def getUrl(encoded_name, sku_s):
        return (
            config("url")
            + "?qtype=crosssell&minCrossSell=7&sku="
            + sku_s
            + "&pname="
            + encoded_name
            + "&orgId=9f630604-daa1-455d-aceb-a4150fa9127c&domain=magento&login=vishnu92@gmail.com&spotDy_uid=2f8d6193-ef61-4f42-9cdc-6acf58a10cf9&limit=10&sitedomain=intertoys&com=intertoys_live"
        )

    def getSkuKey():
        return config("sku")

    def getNameKey():
        return config("name")

    def getDataPath():
        return config("filePath")

    def getCrossSellKey():
        return config("crossSellRecoKey")

    def getCrossSellRankKey():
        return config("crossSellRecoRankKey")

    def getVisibilityKey():
        return config("visibilityKey")
