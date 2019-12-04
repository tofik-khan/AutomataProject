filepath=`pwd`;
echo -n "Enter filename (e.g: RegEx.txt): ";
read filename;
java Main "$filepath/$filename";
