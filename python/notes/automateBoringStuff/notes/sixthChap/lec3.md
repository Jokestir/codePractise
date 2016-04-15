List method
===========


To extract info
----------------


+ **index(member)**          :  returns the index of the argument


   e.g: if spam = ['cat', 'dog', 'rat'] 

        spam.index('dog') returns 1.


+ **count(member)**          : returns the number of occurences of the member

   e.g: if spam = ['cat', 'dog', 'rat', 'cat'] then **spam.count('cat')** returns 

        2



List modifications
------------------


1. **append(member)**         : add member at the end of the list


   e.g: if spam = ['cat', 'dog', 'rat'] then **spam.append('mongoose')**
        
        spam = ['cat', 'dog', 'rat','mongoose']


2. **insert(index,member)**   : add member at index position


   e.g: if spam  = ['cat','dog','rat'] then **spam.insert(1,'chicken')** 

        ['cat', 'chicken', 'dog', 'rat']


3. **extend(seq)**            : apends seq at the end of the list

   e.g if spam  = ['cat','dog','rat'] and seq = ['hello','hi'] then **spam.extend(seq) **
                
       ['1','2','3','hello','hi']


4. **remove(member)**         :   remove the member from the list

   e.g: if spam  = ['cat','dog','rat'] then **spam.remove('dog')** 
                                                                    
        ['cat', 'rat']
                                        

5. **pop (index)**             : removes and returns the member at index

  e.g: if spam  = ['cat','dog','rat']
						
       spam.pop() --> abc
	

        spam.pop(2) --> zara


6. **clear()**                 : empty the list

  e.g: if spam = ['1', '2','3'], **spam.clear()** 

        spam = []
				 

7. **reverse()**               : reverses the list

  e.g: if spam = ['cat','dog','rat'] then **spam.reverse()**

       ['rat','dog','cat']

8. **sort()**                  : sort the list 
  
  e.g: if spam = ['3', '1', '2']  then **spam.sort() **
 
       ['1','2','3']





Notes
-----


* To delete by **index**, use pop or **del**. To remove by member, use **remove(member)**


* **index(member)** throws a exception if member is **not** in the list

* **sort()** will only work on list containing only **strings** or **numbers**. if the list contains **both** strings as well as numbers, it raises an **exception**

* **sort(reverse=True)** for sorting in reverse. **sort(key=str.lower)** to sort in **alphabetical** order.

