//adding the measurements needed before csv export
detectionToAnnotationDistancesSigned(true)
selectDetections();
runPlugin('qupath.lib.algorithms.IntensityFeaturesPlugin', '{"pixelSizeMicrons":1.0,"region":"ROI","tileSizeMicrons":25.0,"channel1":true,"channel2":true,"channel3":true,"channel4":true,"channel5":true,"channel6":true,"channel7":true,"channel8":true,"channel9":true,"channel10":true,"channel11":true,"channel12":true,"channel13":true,"channel14":true,"channel15":true,"channel16":true,"channel17":true,"channel18":true,"channel19":true,"channel20":true,"channel21":true,"channel22":true,"channel23":true,"channel24":true,"channel25":true,"channel26":true,"channel27":true,"channel28":true,"channel29":true,"channel30":true,"channel31":true,"channel32":true,"channel33":true,"channel34":true,"channel35":true,"channel36":true,"channel37":true,"channel38":true,"doMean":true,"doStdDev":true,"doMinMax":true,"doHaralick":false,"haralickMin":0.1,"haralickMax":1.0,"haralickDistance":1,"haralickBins":32}')
selectDetections();
addShapeMeasurements("AREA", "LENGTH", "CIRCULARITY", "SOLIDITY", "MAX_DIAMETER", "MIN_DIAMETER")
