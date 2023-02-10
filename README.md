# Postfix Evaluation (Java)
Simple Java source code application to *Evaluate Postfix Expression* by using application of *Stack* in data structure and algorithm.<br>

## License
The source code has been published on GitHub Repository under *MIT License*.<br>
Please visit `LICENSE` file to read the details about the license.

## How to use ?
Source code is available on folder `src` and file name is `evaluatePostfix.java` .
You may run the Java source code directly on any Java supported compiler.

Invoke method `evalPostfix(String)` with string parameter of postfix expression.<br>
The `evalPostfix(String)` need to be called inside the `main` method .<br>
The output of *postfix evaluation* will be returned as *double* datatype.

**Eg. 1:** 
Input postfix expression :  `7 4 + 3 / -2 *`<br>
The output will be : `-7.33`<br>

![enter image description here](https://raw.githubusercontent.com/iamashraff/Postfix-Evaluation/main/img/example1.png)

##

 **Eg. 2:**
**Input postfix expression**  `7 4 3 -2 + / *`<br>
The output will be : `28`<br>

![enter image description here](https://raw.githubusercontent.com/iamashraff/Postfix-Evaluation/main/img/example2.png)

##
 **Eg. 3:**
**Input postfix expression**  `7 4 3 + / -2 *`<br>
The output will be : `-2`<br>
![enter image description here](https://raw.githubusercontent.com/iamashraff/Postfix-Evaluation/main/img/example3.png)

##
 **Eg. 4:**
**Input postfix expression**  `7 4 + 3 + -2 +`<br>
The output will be : `12`<br>
![enter image description here](https://raw.githubusercontent.com/iamashraff/Postfix-Evaluation/main/img/example4.png)

## How it works ?
1. The algorithm read the string value of postfix expression from left to right. `(Use for loop in line 46)`
2. If the value is an `operand`, then the algorithm will push the element into the top of the stack. `(Refer line 63)`
3. However, if the value is an `operator`, then the algorithm will pop two element from the top of the stack and evaluate the value. `(Refer line 85-149)`
4. The evaluated value then being pushed back into the top of the stack until the end of expression.

> Note: The algorithm are able to evaluate operand which has more than 2 digit value , decimal value and negative value.

## References
[1]  Carrano, F. M. (2011). _Data Structures and Abstractions with Java (3rd Edition)_ (3rd ed.). Pearson.

##
## Visual Studio Code (VS Code) Readme
 **Folder Structure**
The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

> If you want to customize the folder structure, open `.vscode/settings.json` and update the related settings there.

**Dependency Management**
The `JAVA PROJECTS` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).

## Credit
**Developed by :**<br>
Muhamad Ashraff Othman<br>
© 2021-2022 All rights reserved.<br>

