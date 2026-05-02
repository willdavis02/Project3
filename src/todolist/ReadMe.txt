*Concepts Used*

1. Inheritance & Polymorphism

Inheritance is implemented through the abstract Task class and its subclasses 
(SimpleTask, PriorityTask, and RecurringTask). These subclasses extend the base functionality of Task while 
introducing specialized behavior. Polymorphism is utilized by treating all task objects uniformly as instances 
of the Task class, allowing methods to operate on different task types while maintaining flexibility and scalability.

2. ArrayList

A custom implementation of an ArrayList (MyArrayList) is used as the primary data structure 
to store all tasks. This structure supports dynamic resizing and allows efficient access, 
insertion, and removal of elements by index. It serves as the central repository for managing 
all task objects within the application.

3. Stack

A Stack is used to implement the undo functionality. Each action performed on a task 
(such as adding, removing, or completing a task) is stored as an UndoLastAction object
and pushed onto the stack. When an undo operation is requested, the most 
recent action is popped from the stack and reversed fillowing LIFO principle.

4. LinkedList

A LinkedList is used as the underlying data structure for the queue of today’s tasks. 

5. Queue

A Queue is used to manage tasks that are designated for completion on the current day. 
Tasks are loaded into the queue and processed in FIFO order.


*How to Compile and Run*

Prerequisites

1. Java Development Kit (JDK) version 8 or higher installed
2. IDE(this project was completed in Eclipse), or a terminal/command prompt

Compile and Run

Open your terminal or command prompt, navigate to the directory containing the source file, and run:
1. javac todolist/*.java
2. java todolist.Main


*Notes*

1. Tasks are managed using a custom-built MyArrayList implementation.

2. Undo functionality supports reversing add, remove, and complete actions.

3. A queue is used to manage and process today’s tasks.

4. Filtering is supported by completion status, task type, and priority level.






