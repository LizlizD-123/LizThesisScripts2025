//https://forum.image.sc/t/importing-cell-types-back-into-qupath-by-object-id/76718/8

//edited from above forum post scripts

// Path to CSV file

//Make sure to open the .csv in excel first, and change the name of the "Object.ID" to "Object ID" and then save it
//noIFNg below
//def path = "D:/ElizabethD/Workflow 2 IMCAnalysis 20250328 mantis and flow/analysis/4_pyprofiler_output/20250521_final_cluster_fixed_adipo_RO_QP.csv"
//IFNg cell types below
def path = "D:/ElizabethD/Workflow 2 IMCAnalysis 20250328 mantis and flow/analysis/4_pyprofiler_output/20250705_final_cluster_fixed_adipo_RO_QPIFNg_2.csv"
println ("import csv done!")

// Color separator
def delim = ","

println ("delim set done!")

// Get a map from cell ID -> cell
def cells = getCellObjects()
//println ("get image cells done!")
def cellsById = cells.groupBy(c -> c.getID().toString())
//print cellsById
//println ("get image cell id done!")

print cellsById.size()

// Read lines
def lines = new File(path).readLines()
//println ("def csv lines done!")
print lines
def header = lines.pop().split(delim)
//println ("def csv header done!")

print lines.size()
print header

// Handle each line
for (def line in lines) {
    def map = lineToMap(header, line.split(delim))
    
    //println "map"
    def id = map["Object ID"]
    //print map['Object ID']
    
    //print id
    
    
    def cell = cellsById[id]
    if (cell == null) {
        println "WARN: No cell found for $id"
        continue
    } else if (cell.size() != 1) {
        println "WARN: ${cell.size()} cells for $id - will skip"
        continue
    }
    // Can set a list of classifications like this (will be auto-converted to PathClass in v0.4)
    cell[0].classifications = [map['Class']]
}

// Helper function to create a map from column headings -> values
Map lineToMap(String[] header, String[] content) {
    def map = [:]
    if (header.size() != content.size()) {
        throw new IllegalArgumentException("Header length doesn't match the content length!")
    }
    for (int i = 0; i < header.size(); i++)
        map[header[i]] = content[i]
    return map
}
