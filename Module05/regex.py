#!/usr/bin/python
import re

'''
line = "Cats are smarter than dogs"

matchObj = re.match( r'(.*) are (.*?) .*', line, re.M|re.I)

if matchObj:
   print("matchObj.group() : ", matchObj.group())
   print("matchObj.group(1) : ", matchObj.group(1))
   print("matchObj.group(2) : ", matchObj.group(2))
   #print("matchObj.group(3) : ", matchObj.group(2))
else:
   print("No match!!")


str = 'an example word:catatonic!!'
match = re.search(r'word:\w\w\w\w', str)
# If-statement after search() tests if it succeeded
if match:
  print('found', match.group()) ## 'found word:cat'
else:
  print('did not find')


match = re.search(r'word:\w', str)
if match:
  print('found', match.group()) ## 'found word:cat'
else:
  print('did not find')
'''

str = 'XbZ'


match = re.search(r'X.Z', str)
if match:
  print('found', match.group()) ## 'found word:cat'
else:
  print('did not find')