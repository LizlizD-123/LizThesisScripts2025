def detections = getDetectionObjects()
def name = getCurrentImageName()
mkdirs("D:/ElizabethD/20241227 Qupath batch IMC project/cells geojson files")
def path = "D:/ElizabethD/20241227 Qupath batch IMC project/cells geojson files"+ "/" +name + ".geojson"

// 'FEATURE_COLLECTION' is standard GeoJSON format for multiple objects
//exportObjectsToGeoJson(detections, path, "FEATURE_COLLECTION")

// The same method without the 'FEATURE_COLLECTION' parameter outputs a simple JSON object/array
exportObjectsToGeoJson(detections, path)
