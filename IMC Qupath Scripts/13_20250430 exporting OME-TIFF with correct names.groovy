//Exporting for R steps
//ensures names of the images are correct
def imageData = getCurrentImageData()
def name = GeneralTools.getNameWithoutExtension(imageData.getServer().getMetadata().getName())
def server= getCurrentServer()
mkdirs("D:/ElizabethD/20241227 Qupath batch IMC project/exported .ome.tiff 20240430")
def path = "D:/ElizabethD/20241227 Qupath batch IMC project/exported .ome.tiff 20240430"+ "/" +name + ".ome.tiff"

// 'FEATURE_COLLECTION' is standard GeoJSON format for multiple objects
//exportObjectsToGeoJson(detections, path, "FEATURE_COLLECTION")

// The same method without the 'FEATURE_COLLECTION' parameter outputs a simple JSON object/array
writeImage(server, path)
println "done!"
