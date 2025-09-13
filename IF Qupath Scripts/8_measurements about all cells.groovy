  
  //20250127 Making meaurements to export
  //Elizabeth Dunn
  //first counting cell numbers, then counting IFNg cells (by classification), then counting CD56 and CD3 cells and CD56:CD3, also counting and adding percentages for measurement
  //has if loops in case a measurement is 0, stops the script from getting stuck
  
  
  
  
  
  
  //total number of cells detected in annotation
    
for (annotation in getAnnotationObjects()){
   
    TotalCellsInThisAnnotation= annotation.getChildObjects().findAll{it.isCell()}//use it.isCell to be sure to count cells only not just all detections
    print ("I have " + TotalCellsInThisAnnotation.size() + " cells")
    for (cell in TotalCellsInThisAnnotation ){
        TotalCellsInThisAnnotation_sum = TotalCellsInThisAnnotation.size()
    }
    annotation.getMeasurementList().put("Cells detected in annotation",TotalCellsInThisAnnotation_sum)
    }
    println'num cells estimated script done'
    
    
    
    
    //Measuring total cells counted as IFNg+. This will count all cells with a subcellular detection from the previous step. Cells are positive if they have spot and or estimated spot (estimated derived from a cluster).


      
for (annotation in getAnnotationObjects()){
    IFNgPositiveCellsInThisAnnotation= annotation.getChildObjects().findAll{it.isCell()&& measurement(it, "total estimated spots" )>=1}
     print ("I have " + IFNgPositiveCellsInThisAnnotation.size() + " IFNg+ cells")
     if (IFNgPositiveCellsInThisAnnotation.size()>0){
     IFNgPositiveCellsInThisAnnotation_sum=IFNgPositiveCellsInThisAnnotation.size()      
    
    annotation.getMeasurementList().put("Num IFNg+ cells",IFNgPositiveCellsInThisAnnotation_sum)}
    else {println '0'}
    }
    println'num IFNg + cells script done'
    
    
         //percentage IFNg+ cells of all cells    
for (annotation in getAnnotationObjects()) {
    if (IFNgPositiveCellsInThisAnnotation.size()>0){
    percentageIFNgpositivecells_ofallcells= (IFNgPositiveCellsInThisAnnotation_sum/TotalCellsInThisAnnotation_sum)*100

    annotation.getMeasurementList().putMeasurement("Percentage IFNg+ cells of all cells",percentageIFNgpositivecells_ofallcells)}
    else {println '0'}
    }
    println'%IFNg+ cells of all cells done'
    
    
      //Measuring positivity of cells in each image, how many cells with 0 spot (including estimated), how many with 1 spot, and how many with >1 spot?
    

    for (annotation in getAnnotationObjects()){
    CellsInThisAnnotation_nospot= annotation.getChildObjects().findAll{it.isCell() && measurement(it, "total estimated spots" )==0}
     print ("I have " + CellsInThisAnnotation_nospot.size() + " CellsInThisAnnotation_nospot")
     if (CellsInThisAnnotation_nospot.size()>0){
     CellsInThisAnnotation_nospot_sum=CellsInThisAnnotation_nospot.size()      
    
    annotation.getMeasurementList().putMeasurement("Num cells no spot",CellsInThisAnnotation_nospot_sum)}
    else {println '0'}
    }
    println'num cells with 0 spot cells script done'
    
  for (annotation in getAnnotationObjects()) {
      if (CellsInThisAnnotation_nospot.size()>0){
    percentage_CellsInThisAnnotation_nospot_ofallcells= (CellsInThisAnnotation_nospot_sum/TotalCellsInThisAnnotation_sum)*100

    annotation.getMeasurementList().putMeasurement("Percentage no spot cells of all cells",percentage_CellsInThisAnnotation_nospot_ofallcells)}
    else {println '0'}
    }
    println'percentage_CellsInThisAnnotation_nospot_ofallcells done'  
    
        /*for (annotation in getAnnotationObjects()){
    CellsInThisAnnotation_onespot= annotation.getChildObjects().findAll{it.isCell() && measurement(it, "total estimated spots" )==1}
     print ("I have " + CellsInThisAnnotation_onespot.size() + " one cluster cells")
     for (cell in CellsInThisAnnotation_onespot){
     CellsInThisAnnotation_onespot_sum=CellsInThisAnnotation_onespot.size()      
    }
    annotation.getMeasurementList().putMeasurement("Num cells one spot",CellsInThisAnnotation_onespot_sum)
    }
    println'num cells with one spot done'
    
    
      for (annotation in getAnnotationObjects()) {
    percentage_CellsInThisAnnotation_onespot_ofallcells= (CellsInThisAnnotation_onespot_sum/TotalCellsInThisAnnotation_sum)*100

    annotation.getMeasurementList().putMeasurement("Percentage one spot cells of all cells",percentage_CellsInThisAnnotation_onespot_ofallcells)
    }
    println'percentage_CellsInThisAnnotation_onespot_ofallcells done'  
    
    
      for (annotation in getAnnotationObjects()){
    CellsInThisAnnotation_greaterthanonespot= annotation.getChildObjects().findAll{it.isCell() && measurement(it, "total estimated spots" )>1}
     print ("I have " + CellsInThisAnnotation_greaterthanonespot.size() + " greater than one cluster cells")
     for (cell in CellsInThisAnnotation_greaterthanonespot){
     CellsInThisAnnotation_greaterthanonespot_sum=CellsInThisAnnotation_greaterthanonespot.size()      
    }
    annotation.getMeasurementList().putMeasurement("Num cells greater than one spot",CellsInThisAnnotation_greaterthanonespot_sum)
    }
    println'num cells with greater than one spot done'
    
      for (annotation in getAnnotationObjects()) {
    percentage_CellsInThisAnnotation_greaterthanonespot_ofallcells= (CellsInThisAnnotation_greaterthanonespot_sum/TotalCellsInThisAnnotation_sum)*100

    annotation.getMeasurementList().putMeasurement("Percentage greater than 1 spot cells of all cells",percentage_CellsInThisAnnotation_greaterthanonespot_ofallcells)
    }
    println'percentage_CellsInThisAnnotation_greaterthanonespot_ofallcells done'  */  
    
    
    
            for (annotation in getAnnotationObjects()){
    CellsInThisAnnotation_3spot= annotation.getChildObjects().findAll{it.isCell() && measurement(it, "total estimated spots" )>=1 && measurement (it, "total estimated spots" )<4}
     print ("I have " + CellsInThisAnnotation_3spot.size() + " 1-3 spot cells")
     if (CellsInThisAnnotation_3spot.size()>0){
     CellsInThisAnnotation_3spot_sum=CellsInThisAnnotation_3spot.size()   
    annotation.getMeasurementList().putMeasurement("Num cells 1-3 spot",CellsInThisAnnotation_3spot_sum)}
    else {println '0'}
    }
    println'num cells with 1-3 spot done'

               for (annotation in getAnnotationObjects()) {
                   if (CellsInThisAnnotation_3spot.size()>0){
    percentage_CellsInThisAnnotation_3spot_ofIFNgcells= (CellsInThisAnnotation_3spot_sum/IFNgPositiveCellsInThisAnnotation_sum)*100

    annotation.getMeasurementList().putMeasurement("Percentage 1-3 spot cells of IFNg+ cells",percentage_CellsInThisAnnotation_3spot_ofIFNgcells)}
    else {println '0'}
    }
    println'percentage_CellsInThisAnnotation_3spot_ofIFNg+cells done' 
    
            for (annotation in getAnnotationObjects()){
    CellsInThisAnnotation_9spot= annotation.getChildObjects().findAll{it.isCell() && measurement(it, "total estimated spots" )>=4 && measurement (it, "total estimated spots" )<10}
     print ("I have " + CellsInThisAnnotation_9spot.size() + " 4 -9 spot cells")
     if (CellsInThisAnnotation_9spot.size()>0){
     CellsInThisAnnotation_9spot_sum=CellsInThisAnnotation_9spot.size()    
    annotation.getMeasurementList().putMeasurement("Num cells 4-9 spot",CellsInThisAnnotation_9spot_sum)}
    else {println '0'}
    }
    println'num cells with 4-9 spot done'

               for (annotation in getAnnotationObjects()) {
                   if (CellsInThisAnnotation_9spot.size()>0){
    percentage_CellsInThisAnnotation_5spot_ofIFNgcells= (CellsInThisAnnotation_9spot_sum/IFNgPositiveCellsInThisAnnotation_sum)*100

    annotation.getMeasurementList().putMeasurement("Percentage 4-9 spot cells of IFNg+ cells",percentage_CellsInThisAnnotation_5spot_ofIFNgcells)}
    else {println '0'}
    }
    println'percentage_CellsInThisAnnotation_9spot_ofIFNg+cells done' 
    
    //
    
               for (annotation in getAnnotationObjects()){
    CellsInThisAnnotation_10spot= annotation.getChildObjects().findAll{it.isCell() && measurement(it, "total estimated spots" )>=10 && measurement (it, "total estimated spots" )<=15}
     print ("I have " + CellsInThisAnnotation_10spot.size() + " 10-15 spot cells")
    if (CellsInThisAnnotation_10spot.size()>0){
     CellsInThisAnnotation_10spot_sum=CellsInThisAnnotation_10spot.size()      
    
    annotation.getMeasurementList().putMeasurement("Num cells 10-15 spot",CellsInThisAnnotation_10spot_sum)}
    else {println '0'}
    }
    println'num cells with 10-15 spot done'

               for (annotation in getAnnotationObjects()) {
                   if (CellsInThisAnnotation_10spot.size()>0){
    percentage_CellsInThisAnnotation_10spot_ofIFNgcells= (CellsInThisAnnotation_10spot_sum/IFNgPositiveCellsInThisAnnotation_sum)*100

    annotation.getMeasurementList().putMeasurement("Percentage 10-15 spot cells of IFNg+ cells",percentage_CellsInThisAnnotation_10spot_ofIFNgcells)}
    else {println '0'}
    }
    println'percentage_CellsInThisAnnotation_10spot_ofIFNg+cells done' 
    
        //
    
               for (annotation in getAnnotationObjects()){
    CellsInThisAnnotation_15spot= annotation.getChildObjects().findAll{it.isCell() && measurement(it, "total estimated spots" )>15}
     print ("I have " + CellsInThisAnnotation_15spot.size() + " >15 spot cells")
 
         if (CellsInThisAnnotation_15spot.size()>0){
     CellsInThisAnnotation_15spot_sum=CellsInThisAnnotation_15spot.size()
       annotation.getMeasurementList().putMeasurement("Num cells >15 spot",CellsInThisAnnotation_15spot_sum)}
     else {println '0'}
    
  
    }
    println'num cells with 10-15 spot done'

               for (annotation in getAnnotationObjects()) {
                   if (CellsInThisAnnotation_15spot.size()>0){
    percentage_CellsInThisAnnotation_15spot_ofIFNgcells= (CellsInThisAnnotation_15spot_sum/IFNgPositiveCellsInThisAnnotation_sum)*100

    annotation.getMeasurementList().putMeasurement("Percentage >15 spot cells of IFNg+ cells",percentage_CellsInThisAnnotation_15spot_ofIFNgcells)}
    else {println '0'}
    }
    println'percentage_CellsInThisAnnotation_15spot_ofIFNg+cells done' 
    
        //measuring number of NK cells
    
for (annotation in getAnnotationObjects()){
   
    TotalNKCellsInThisAnnotation= annotation.getChildObjects().findAll{it.isCell()&& it.getPathClass()== getPathClass ("CD56")}//use it.isCell to be sure to count cells only not just all detections
    print ("I have " + TotalNKCellsInThisAnnotation.size() + " NK cells")
    if (TotalNKCellsInThisAnnotation.size()>0){
        TotalNKCellsInThisAnnotation_sum = TotalNKCellsInThisAnnotation.size()
    
    annotation.getMeasurementList().putMeasurement("NK cells detected in annotation",TotalNKCellsInThisAnnotation_sum)}
    }
    println'num NK cells estimated script done'
    
    
    //measuring number of T cells
    
 for (annotation in getAnnotationObjects()){
   
    TotalTCellsInThisAnnotation= annotation.getChildObjects().findAll{it.isCell()&& it.getPathClass()== getPathClass ("CD3")}//use it.isCell to be sure to count cells only not just all detections
    print ("I have " + TotalTCellsInThisAnnotation.size() + " T cells")
  if (TotalTCellsInThisAnnotation.size()>0){
        TotalTCellsInThisAnnotation_sum = TotalTCellsInThisAnnotation.size()
    
    annotation.getMeasurementList().putMeasurement("T cells detected in annotation",TotalTCellsInThisAnnotation_sum)}
    else {println '0'}
    }
    println'num T cells estimated script done'
   
    
    
          //measuring number of IFNg positive NK cells. Using != to make sure to exlude CD3+ cells from count
for (annotation in getAnnotationObjects()){
    IFNgPositiveNKCellsInThisAnnotation= annotation.getChildObjects().findAll{it.isCell()&& it.getPathClass()== getPathClass ("CD56") && it.getPathClass()!= getPathClass ("CD3") &&  measurement(it, "total estimated spots" )>0}
     print ("I have " + IFNgPositiveNKCellsInThisAnnotation.size() + " IFNg+ NK cells")
     if (IFNgPositiveNKCellsInThisAnnotation.size()>0){
     IFNgPositiveNKCellsInThisAnnotation_sum=IFNgPositiveNKCellsInThisAnnotation.size()      
    
    annotation.getMeasurementList().putMeasurement("Num IFNg+ NK cells",IFNgPositiveNKCellsInThisAnnotation_sum)}
    else {println '0'}
    }
    println'num IFNg + NK cells script done'

          //measuring number of IFNg positive T cells. Using != to make sure to exlude CD56+ cells from count
for (annotation in getAnnotationObjects()){
    IFNgPositiveTCellsInThisAnnotation= annotation.getChildObjects().findAll{it.isCell()&& it.getPathClass()== getPathClass ("CD3") && it.getPathClass()!= getPathClass ("CD56") && measurement(it, "total estimated spots" )>0}
     print ("I have " + IFNgPositiveTCellsInThisAnnotation.size() + " IFNg+ T cells")
     if (IFNgPositiveTCellsInThisAnnotation.size()>0){
     IFNgPositiveTCellsInThisAnnotation_sum=IFNgPositiveTCellsInThisAnnotation.size()      
    
    annotation.getMeasurementList().putMeasurement("Num IFNg+ T cells",IFNgPositiveTCellsInThisAnnotation_sum)}
    else {println '0'}
    }
    println'num IFNg + T cells script done'
    
    

    
    //percentage NK cells of all cells    
for (annotation in getAnnotationObjects()) {
    if (TotalNKCellsInThisAnnotation.size()>0){
    percentageNKcells_ofallcells= (TotalNKCellsInThisAnnotation_sum/TotalCellsInThisAnnotation_sum)*100
    annotation.getMeasurementList().putMeasurement("Percentage NK cells of all cells",percentageNKcells_ofallcells)}
    else {println '0 NK cells'}

    
    }
    println'% NK cells of all cells done'
    
    //percentage INFg+ NK cells of all IFNg+ cells
for (annotation in getAnnotationObjects()) {
    if (IFNgPositiveNKCellsInThisAnnotation.size()>0){
    percentageIFNgpositiveNKcells_ofallIFNgpositivecells= (IFNgPositiveNKCellsInThisAnnotation_sum/IFNgPositiveCellsInThisAnnotation_sum)*100
    annotation.getMeasurementList().putMeasurement("Percentage IFNg+ NK cells of all IFNg+ cells",percentageIFNgpositiveNKcells_ofallIFNgpositivecells)}
    else {println '0'}
    }
    println'%IFNg+ NK cells of all IFNg+ cells done'
    //percentage NK cells of all cells
    
    //percentage IFNg + NK cells of all NK cells
for (annotation in getAnnotationObjects()) {
    if (IFNgPositiveNKCellsInThisAnnotation.size()>0){
    percentageIFNgpositiveNKcells_ofallNKcells= (IFNgPositiveNKCellsInThisAnnotation_sum/TotalNKCellsInThisAnnotation_sum)*100

    annotation.getMeasurementList().putMeasurement("Percentage IFNg+ NK cells of all NK cells",percentageIFNgpositiveNKcells_ofallNKcells)}
    else {println '0'}
    }    
    println'%INFg+ NK cells of NK cells done'
    
    
    //percentage T cells of all cells
    
for (annotation in getAnnotationObjects()) {
    if (TotalTCellsInThisAnnotation.size()>0){
    percentageTcells_ofallcells= (TotalTCellsInThisAnnotation_sum/TotalCellsInThisAnnotation_sum)*100

    annotation.getMeasurementList().putMeasurement("Percentage T cells of all cells",percentageTcells_ofallcells)}
    else {println '0'}
    }
    println'% T cells of all cells done'
    
   //percentage INFg+ T cells of all IFNg+ cells
for (annotation in getAnnotationObjects()) {
    if (IFNgPositiveTCellsInThisAnnotation.size()>0){
    percentageIFNgpositiveTcells_ofallIFNgpositivecells= (IFNgPositiveTCellsInThisAnnotation_sum/IFNgPositiveCellsInThisAnnotation_sum)*100

    annotation.getMeasurementList().putMeasurement("Percentage IFNg+ T cells of all IFNg+ cells",percentageIFNgpositiveTcells_ofallIFNgpositivecells)}
    else {println '0'}
    }
    println'%IFNg+ T cells of all IFNg+ cells done'
    
    //percentage IFNg + T cells of all T cells    
 for (annotation in getAnnotationObjects()) {
     if (IFNgPositiveTCellsInThisAnnotation.size()>0){
    percentageIFNgpositiveTcells_ofallTcells= (IFNgPositiveTCellsInThisAnnotation_sum/TotalTCellsInThisAnnotation_sum)*100

    annotation.getMeasurementList().putMeasurement("Percentage IFNg+ T cells of all T cells",percentageIFNgpositiveTcells_ofallTcells)}
    else {println '0'}
    }  
    println'%IFNg+ T cells of all T cells done'
    
    

         //measuring number of NK T cells
     

 for (annotation in getAnnotationObjects()){
   
    TotalNKTCellsInThisAnnotation= annotation.getChildObjects().findAll{it.isCell()&& it.getPathClass()== getPathClass ("CD3:CD56")}//use it.isCell to be sure to count cells only not just all detections
    print ("I have " + TotalNKTCellsInThisAnnotation.size() + " NK T cells")
   
   if (TotalNKTCellsInThisAnnotation.size()>0){
    TotalNKTCellsInThisAnnotation_sum = TotalNKTCellsInThisAnnotation.size()    
    annotation.getMeasurementList().putMeasurement("NK T cells detected in annotation",TotalNKTCellsInThisAnnotation_sum)}
    else {println '0'}
    }
    println'num NK T cells estimated script done' 
    
                 //measuring number of IFNg positive NK T cells.
for (annotation in getAnnotationObjects()){
    IFNgPositiveNKTCellsInThisAnnotation= annotation.getChildObjects().findAll{it.isCell()&& it.getPathClass()== getPathClass ("CD3:CD56") && measurement(it, "total estimated spots" )>0}
     print ("I have " + IFNgPositiveNKTCellsInThisAnnotation.size() + " IFNg+ NK T cells")  
        
    
    if (IFNgPositiveNKTCellsInThisAnnotation.size()>0) {
     IFNgPositiveNKTCellsInThisAnnotation_sum=IFNgPositiveNKTCellsInThisAnnotation.size()    
    annotation.getMeasurementList().putMeasurement("Num IFNg+ NK T cells",IFNgPositiveNKTCellsInThisAnnotation_sum)}
    else {println '0'}
    }
    println'num IFNg + NK T cells script done' 

       //percentage NK T cells of all cells
    
for (annotation in getAnnotationObjects()) {
    if (TotalNKTCellsInThisAnnotation.size()>0){
    percentageNKTcells_ofallcells= (TotalNKTCellsInThisAnnotation_sum/TotalCellsInThisAnnotation_sum)*100

    annotation.getMeasurementList().putMeasurement("Percentage NK T cells of all cells",percentageNKTcells_ofallcells)}
    else {println '0'}
    }
    println'% NK T cells of all cells done'
    
   //percentage INFg+ NK T cells of all IFNg+ cells
for (annotation in getAnnotationObjects()) {
    if (IFNgPositiveNKTCellsInThisAnnotation.size()>0){
    percentageIFNgpositiveNKTcells_ofallIFNgpositivecells= (IFNgPositiveNKTCellsInThisAnnotation_sum/IFNgPositiveCellsInThisAnnotation_sum)*100

    annotation.getMeasurementList().putMeasurement("Percentage IFNg+ NK T cells of all IFNg+ cells",percentageIFNgpositiveNKTcells_ofallIFNgpositivecells)}
    else {println '0'}
    }
    println'%IFNg+ NK T cells of all IFNg+ cells done'
    //percentage IFNg + NK T cells of all NK T cells
    
 for (annotation in getAnnotationObjects()) {
     if (IFNgPositiveNKTCellsInThisAnnotation.size()>0){
    percentageIFNgpositiveNKTcells_ofallNKTcells= (IFNgPositiveNKTCellsInThisAnnotation_sum/TotalNKTCellsInThisAnnotation_sum)*100

    annotation.getMeasurementList().putMeasurement("Percentage IFNg+ NK T cells of all NK T cells",percentageIFNgpositiveNKTcells_ofallNKTcells)}
    else {println '0'}
    }  
    println'%IFNg+ NK T cells of all NK T cells done'
