def entry = getProjectEntry()
def name = entry.getImageName()
def fileName = name + ".geojson"

// Build filepath
def pathInput = buildFilePath(PROJECT_BASE_DIR, "cells geojson files", fileName)
println (name)
println (fileName)
println (pathInput)

// Import annotations
importObjectsFromFile(pathInput)

// Finished
println("Done!")
