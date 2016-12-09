#!/bin/bash

pfile_name=$1
max=1000
for count in `seq $max`
do
  result=`java -jar dist/lib/MolComSim.jar -pfile: $pfile_name`
  result=${result#*step: }
  result=${result%%Last*}
  echo $result >> result.csv
  echo -en "$count\r"
done
