# CodingTest
This is for the coding interview repository

## Implement a simple ATM controller
Developed with Java language

1. ATM class : The class implemented the simple ATM controller
2. Bank : The interface comunnicating between the ATM and bank.
3. TestBank : The test bank class having testing databases.

If the user enter the wrong PIN number 5 times, it return back to the main.

### How to build and run it
1. Download all java files
2. run java file (ATM has the main function to execuete and test)
> "C:\Users\Alex\.jdks\openjdk-17.0.2\bin\java.exe -javaagent:C:\Users\Alex\Documents\ideaIU-2021.3.2.win\lib\idea_rt.jar=14177:C:\Users\Alex\Documents\ideaIU-2021.3.2.win\bin -classpath C:\Users\Alex\IdeaProjects\Bear_CodingTest_ATM\out\production\Bear_CodingTest_ATM ATM"

### Test cases
You test with the 'TestBank' class which is having the testing database.
- 3 card : 1111 1111 1111 1111, 2222 2222 2222 2222, 3333 3333 3333 3333
- 3 card's PIN info. : 1234, 5678, 9012
- 6 accounts per card having the balance
    - Each card has 2 accounts

#### TC1 : Enter the correct information and check the balance
![image](https://user-images.githubusercontent.com/5586333/188258160-24265c42-bd59-4367-ac52-7d24b418b7c1.png)

#### TC2 : Enter the correct information and deposit money
![image](https://user-images.githubusercontent.com/5586333/188258195-94d177fd-8e9c-485c-88f2-a8e1c5c3f0be.png)

#### TC3 : Enter the correct information and withdraw money
![image](https://user-images.githubusercontent.com/5586333/188258295-31af5299-603c-4c76-8cdc-e54e85dd527d.png)

#### TC4 : Enter the incorrect card number
![image](https://user-images.githubusercontent.com/5586333/188258316-19285a52-90e2-4c7a-b811-6cccb56c044a.png)

#### TC5 : Enter the incorrect PIN
![image](https://user-images.githubusercontent.com/5586333/188258344-004e56ec-a240-48f6-bc8d-8a14db99f69a.png)

#### TC6 : Enter the wrong account or transaction index number
![image](https://user-images.githubusercontent.com/5586333/188258381-17c43b54-1354-44a4-8bd3-b126d0e34cc6.png)

#### TC7 : Enter the negative amount to deposit, withdraw
![image](https://user-images.githubusercontent.com/5586333/188258408-61728203-db32-4675-8c9e-801af3ed87f8.png)

#### TC8 : Enter the bigger amount than the balance when try to withdraw
![image](https://user-images.githubusercontent.com/5586333/188259105-f5823680-e1c7-498f-b2ee-58f78b2bab07.png)

#### TC9 : Enter the big number
![image](https://user-images.githubusercontent.com/5586333/188259063-80692afc-275c-4697-bbb4-6d09d8bf28f1.png)
