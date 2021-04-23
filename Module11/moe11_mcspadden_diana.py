## Shared Resource Description
'''
The shared resource is the laundry hamper. 
* 5 humans are depositing items of dirty laundry in the hamper
* The hamper holds 100 items of dirty laundry (for this toy problem, after 100 items of dirty laundry have been put in the hamper, the humans must just keep wearing dirty clothes).
* Laundry loads are only performed when there are 20 items of dirty laundry, and a load only cleans 20 items of dirty laundry.
* There are never negative numbers of dirty laundry items.
* While there are **5** humans creating dirty laundry, there is only **1** washing machine to clean the laundry.
'''

### Implementation:
'''
* My toy problem lets the humans add a random number of dirty items between 1 and 5 dirty items
* And, while ideally, a full laundry load has exactly 20 items and the condition is only met when more than 20 items are available for a load, I allow some "human" error and laundry loads clean a random number of items between 18 and 20.
* And, ideally, the full hamper could only hold 100 items, it can hold up to 102 items because of the random amount that can be added.
'''

# include the libraries needed
from threading import Thread
import threading
import time
import random # for random number of items to add to laundry hamper and to clean in a laundy load

class LaundryHamper:
  def __init__(self):
    self.lock = threading.Lock()
    self.fullLaundryLoadCondition = threading.Condition(self.lock)
    self.dirtyItemCount = 0

  def addDirtyItems(self, humanName):
    self.lock.acquire()
    try:
      # only add items if the laundry hamper has fewer than 100 items
      while (self.dirtyItemCount >= 100):
        self.fullLaundryLoadCondition.wait()

      # determine how many dirty items this human will add: between 1 and 3
      numberOfDirtyItems = random.randint(1,6)
      # add the dirty items to the hamper
      newCount = self.dirtyItemCount + numberOfDirtyItems
      self.dirtyItemCount = newCount

      # print the current hamper balance and who added items
      print("%s added %d items to the hamper. Number of dirty items in hamper is: %d" % (humanName, numberOfDirtyItems, newCount))
      # notify the other threads
      self.fullLaundryLoadCondition.notifyAll()
    except:
      print("The laundry hamper broke.")
    finally:
      self.lock.release()
  
  def cleanLaundry(self):
    self.lock.acquire()
    try:
      # wait until there are 20 dirty laundry items to do a load of laundry
      while (self.dirtyItemCount < 20):
        self.fullLaundryLoadCondition.wait()

      # determine how many dirty items will be cleaned
      numberOfItemsToClean = random.randint(18,20)
      # remove the items from the hamper
      newCount = self.dirtyItemCount - numberOfItemsToClean
      self.dirtyItemCount = newCount

      # print the current hamper balance after cleaning
      print("A load of laundry with %d items was completed. Number of dirty items in hamper is: %d" % (numberOfItemsToClean, newCount))
      # notify the other threads
      self.fullLaundryLoadCondition.notifyAll()

    except:
      print("The washing machine broke.")
    finally:
      self.lock.release()
  
  def getNumberOfHamperItems(self):
    return self.dirtyItemCount

def triggerAddingDirtyLaundry(hamper, humanName, days):
  for i in range(days):
    hamper.addDirtyItems(humanName)
    # add a little time between adding dirty laundry
    time.sleep(1)

def triggerCleanLaundry(hamper, numLoads):
  for i in range(numLoads):
    hamper.cleanLaundry()
    # add a little time between laundry loads
    time.sleep(2)


if __name__ == '__main__':

    hamper = LaundryHamper()
    human1 = "Buffy"
    human2 = "Willow"
    human3 = "Xander"
    human4 = "Tara"
    human5 = "Giles"

    t_h1 = Thread(target=triggerAddingDirtyLaundry, args=(hamper, human1, 14,))
    t_h2 = Thread(target=triggerAddingDirtyLaundry, args=(hamper, human2, 14,))
    t_h3 = Thread(target=triggerAddingDirtyLaundry, args=(hamper, human3, 14,))
    t_h4 = Thread(target=triggerAddingDirtyLaundry, args=(hamper, human4, 14,))
    t_h5 = Thread(target=triggerAddingDirtyLaundry, args=(hamper, human5, 14,))

    t_clean1 = Thread(target=triggerCleanLaundry, args=(hamper, 3,))
    t_clean2 = Thread(target=triggerCleanLaundry, args=(hamper, 3,))
    t_clean3 = Thread(target=triggerCleanLaundry, args=(hamper, 3,))
    t_clean4 = Thread(target=triggerCleanLaundry, args=(hamper, 3,))

    t_clean1.start()
    t_h1.start()
    t_h2.start()
    t_clean2.start()
    t_h3.start()
    t_clean3.start()
    t_clean4.start()
    t_h4.start()
    t_h5.start()

    time.sleep(10)

    # after 30 seconds kill the threads
    t_clean1.join()
    t_h1.join()
    t_h2.join()
    t_clean2.join()
    t_h3.join()
    t_clean3.join()
    t_clean4.join()
    t_h4.join()
    t_h5.join()
    
    print("Laundry Example Finished.")