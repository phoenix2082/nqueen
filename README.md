# nqueen

This is demo project for solution to N-Queen problem.

## Building the JAR

To build this project, just clone the repository and run following command.

$ nqueen % ./gradlew jar

This will create executable jar at path - "build/libs/nqueen.jar".

## Running the JAR

You can run executable jar with following command.

$ java -jar build/libs/nqueen.jar N y

Currently two arguments are supported. 

N -> Required. which is number of Queens on N x N board. Valid values are N = 4, 5, 6,......
y -> Options. just 'y' to print all possible N x N board, which meets the criteria.

NOTE: If second option is not used, the program will print  count of valid board only.

## Writing Boards to text file.

If you are going to run the program from command prompt with 'y', it will print lot of values for N > 6. Better approach is to just pipe it to text file. Example:

 nqueen $ java -jar build/libs/nqueen.jar 5 y > 5.txt
 nqueen % java -jar build/libs/nqueen.jar 6 y > 6.txt
 nqueen % java -jar build/libs/nqueen.jar 7 y > 7.txt 
 nqueen % java -jar build/libs/nqueen.jar 8 y > 8.txt

Then you can view all possible board combination in text file using your favorite text editor.

## Performance

nqueen % time java -jar build/libs/nqueen.jar 4 y > 4.txt

0.09s user 0.03s system 125% cpu 0.097 total

nqueen % time java -jar build/libs/nqueen.jar 5 y > 5.txt

0.15s user 0.03s system 150% cpu 0.123 total

nqueen % time java -jar build/libs/nqueen.jar 6 y > 6.txt

0.27s user 0.04s system 184% cpu 0.169 total

nqueen % time java -jar build/libs/nqueen.jar 7 y > 7.txt

1.98s user 0.12s system 177% cpu 1.183 total

nqueen % time java -jar build/libs/nqueen.jar 8 y > 8.txt

27.93s user 0.19s system 102% cpu 27.555 total

nqueen % time java -jar build/libs/nqueen.jar 9 y > 9.txt

1133.09s user 3.54s system 100% cpu 18:51.88 total
