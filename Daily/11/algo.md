### 1. Write an algorithm to remove duplicate words in a sentence.

##### Algorithm

* Start
* Take string as input
* Initialise string array to empty
* Loop through the characters
  * If the character is not a space or a punctuation
    * Add it to a temporary string variable called word
  * Else
    * If the word is not in the array
      * Add the word variable to the array
      * Empty the word variable
* Print out the array
* Stop

### 2. A program that adds the diagonal element of two matrices

##### Algorithm

* Start
* Take matrix size as input
* Initialise double dimensional array with the size
* Print the matrix
* Initialise an accumulator
* Loop through the matrix elements
  * If the coordinates of the matrix elements are equal or they add up to one less than the size, add the elements to the accumulator
* Loop through the parameterised matrix elements
  * If the coordinates of the matrix elements are equal or they add up to one less than the size, add the elements to the accumulator
* Print out the sum
* Stop