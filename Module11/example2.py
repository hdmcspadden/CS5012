## [File: example2.py]
## Concurrency - Example 
## Python version 3.X

## - Simple threads invoked to count words in files
## - Each thread counts words and reports the number of words
## - One thread for each provided file

# Add this list of books (text files) to the command line when running this Python Script: 
# BramStoker-Dracula.txt  mary1.txt shakespeare-hamlet.txt shakespeare-macbeth.txt
# (Note: space separated not comma separated!) 

import time
from threading import Thread
import sys

def wordCounter(filename):
    print("Counting words in: %s \n" % filename) # print at the start of the thread
    time.sleep(5) # sleep a few seconds, you don't need this in order to see the threading, this just lets all the threads start first
    # Count words in the file: 
    print("There are %d words in %s. \n" % (len(open(filename, "r+").read().split()), filename))


if __name__ == "__main__":
    for i in range(1, len(sys.argv)): # go through list of files that we want to check word count within
        # Thread targets the "wordCounter" function: wordCounter(sys.argv[i])
        t = Thread(target=wordCounter, args=(sys.argv[i],)) # create a thread for each file
        t.start() # start the thread
