# Lab 1: Test-Driven Review

Welcome to CS 2334!
For our first lab, we will complete the following tasks:

* Use Zoom to share code while social distancing in the classroom.
* Join the CS 2334 Discord server.
* Install the JDK and Eclipse.
* Download code from a GitHub repo.
* Import a project into Eclipse.
* Write code that passes a set of provided unit tests.

## Join Your Lab Zoom Meeting

A link to the Zoom meeting can be found on the Canvas page for your lab section.

## Join Our Discord Server

This semester we are using Discord as a hub for answering questions outside of class.
You can connect to our server using the following link: <https://discord.gg/nKpfYZm>.

When you join, you will be unable to read or post messages until we verify your identity.
This can be done either in lab or via email.
Simply tell us your full name and Discord username.
(Your full name will be assigned as your nickname and will appear next to your messages.)

Feel free to discuss anything related to CS 2334 on the server, but please follow these rules:

* Be civil and treat everyone with respect.
* Stay on topic.
There are separate channels for each lecture section and assignment, and we will create additional channels as necessary.
* Avoid posting answers to assignments.
In particular, think carefully before posting code.
The line between acceptable collaboration and academic misconduct can be unclear, so contact [Dr. Maiti](am@ou.edu) or [Dr. Jabrzemski](rjabrzemski@ou.edu) if you have questions about this distinction.

We hope this server becomes a useful place to exchange information, but that will depend on how actively everyone participates.
The next time you have a question about a lecture topic or assignment, consider asking it in a channel before emailing your TA or professor.
On the server, your question can be answered by over 150 people (both students and instructors), and the answer will be available to anyone with the same question.

## Install the JDK and Eclipse

To compile and run Java programs on your laptop, you need to install the Java Development Kit (JDK).
To write Java programs, you can use anything from a simple text editor to an integrated development environment (IDE), such as Eclipse, IntelliJ, or NetBeans.

We won't require you to use a particular editor or IDE in this course, but many of the assignments will include instructions for using Eclipse (including this one).
Furthermore, we don't have the time or expertise to write instructions for every popular IDE.
For these reasons, we encourage you to use Eclipse unless you are already familiar with another tool.

The remainder of this section consists of instructions for installing the latest versions of the JDK and Eclipse.
If you installed this software last semester, you probably don't need to install the latest versions.
However, keep these instructions handy in case you need to switch computers later in the semester.

### Install the JDK

1. Oracle maintains a link to the latest stable version of the JDK on [this site](https://www.oracle.com/java/technologies/javase-downloads.html), which is 14.0.2 at the time of writing.
Click the "JDK Download" link to open to the downloads page.
2. There are two files available for both macOS and Windows: an installer and a compressed archive.
Download the installer for your operating system.
For macOS, this is the .dmg file, not the .tar.gz file.
For Windows, this is the .exe file, not the .zip file.
3. Run the installer and keep the default settings.
4. Delete the .dmg or .exe file after the installation is complete.

### Update the System Path on Windows

Windows users need to add the location of the JDK to their system path in order for Eclipse to find it.

1. Right-click the Start button and select "System" from the pop-up menu.
2. In the window that opens, scroll down to "Related settings" and click "System info."
3. A second window will open.
Click "Advanced system settings" from the options on the left.
4. A third window will open.
Click the "Environment Variables..." button at the bottom.
5. A fourth window will open, which contains two lists: user variables and system variables.
In the bottom list (system variables), select "Path" and then click the "Edit..." button.
6. A fifth window will open.
Click the "New" button.
This will add a new item to the list.
Type the following path (without the quotes): "C:\Program Files\Java\jdk-14.0.2\bin".
Then click the "OK" button.
7. Close out of windows three and four by clicking their respective "OK" buttons.

### Install Eclipse

1. The latest version of Eclipse can be downloaded on [this site](https://www.eclipse.org/downloads/packages/).
Please do not download the installer at the top of the page.
Instead, scroll down to "Eclipse IDE for Java Developers" (*not* "Enterprise Java Developers"), and download the file correspond to your operating system.
2. macOS users: Open the .dmg file from step 1, and drag the Eclipse folder to the Applications folder.
If you would like to add an Eclipse shortcut to the dock, open the Eclipse folder inside the Application folder, and drag the Eclipse launcher to the dock.
3. Windows users: Right-click the .zip file from step 1 and select "Extract All."
The unzipped folder can be moved to any convenient location.
If you would like to add an Eclipse shortcut to your Start menu or taskbar, open the Eclipse folder, right-click the eclipse.exe application, and select "Pin to Start" or "Pin to taskbar."
4. Delete the .dmg or .zip file after completing step 2 or 3.

## Download Your GitHub Repo Files

If you're reading this document, you've created your very own GitHub repository (or "repo" for short).
This repo contains an online copy of the starter code for Lab 1.

At the top of the page is a file browser you can use to view the contents of the repo.
For instance, the text you're reading is stored in the file README.md.
(The file extension "md" stands for "markdown," but it's just a plain text file that you can open in any editor.)
GitHub automatically displays the contents of this file on the homepage of the repo.

If you click on a file, GitHub will show you its contents in an online text editor.
You can use this editor to make changes, but we'll ignore this functionality for now.
Instead, let's make a local copy of the files.

1. If you're not on the homepage of the repo, click the "<> Code" link at the top-left of the page.
2. Click the "Code" button at the top of the file browser.
3. Select "Download ZIP" from the menu and save the file.
4. Unzip the file from step 3 and move the resulting folder to a convient location on your laptop.
(We recommend creating a folder to store all of the programming assignments in this course.)
5. The name of the folder will match the name of your GitHub repo (lab1-username).
You can change the name to something simple like "Lab1".
6. Delete the .zip file from step 3.

## Open the Project in Eclipse

The starter code comes preconfigured to run in Eclipse.
Use the following steps to open the project:

1. Click "File" in the menu bar at the top-left of the Eclipse window.
2. In the drop-down menu, select "Open Projects from File System...".
3. Click the "Directory..." button and navigate to the folder with the starter code.
4. Select the folder and then click the "Finish" button.
Do not change any of the default settings in the import projects window.
In particular, the options "Search for nested projects" and "Detect and configure project natures" should both be checked.
5. A folder named "Lab1" will appear in the Package Explorer on the left side of the Eclipse window.
6. Click the arrow next to Lab1 to reveal the src and test folders.
7. Click the arrows next to src and test to reveal the default package.
Java projects with multiple source files can be organized into different packages to avoid namespace conflicts.
The src and test folders each contain a single .java file in the default package, which is why the same package appears below each folder.
8. Click the arrows next to the packages to reveal the source files: Lab1.java and Lab1Tests.java.
Double-click the files to open them in the editor.

## Run the Unit Tests

Take a look at the class Lab1Tests.
This is a JUnit test class.
Notice that each method is prefixed with the annotation `@Test`.

Click the run button at the top of the Eclipse window.
You will receive a warning that errors exist in the project, but click the "Proceed" button anyway.

A new tab will open next to the package explorer named "JUnit."
The tab includes a list of all the methods with the `@Test` annotation.
Each of these methods is a test, and they're all failing!

The goal of this assignment is to add code to the class Lab1 so that all of the tests pass.
(Don't change the code in Lab1Tests.)
You'll know you're making progress when some of those red X's turn into green checkmarks.

## Write the Lab1 Class

Let's take a closer look at the first test in Lab1Tests, which I'll duplicate below.

```java
@Test
void testSum() {
    assertEquals(Lab1.sum(2, 2), 4);
    assertEquals(Lab1.sum(3, 5), 8);
    assertEquals(Lab1.sum(7, -10), -3);
}
```

The test, which is named "testSum," calls the assertEquals method three times.
(If you look at the other tests, you'll see that they also call methods with names that begin with "assert.")
This is a special JUnit method that defines the test criteria.
To pass the test, `assertEquals` must be given two equal inputs every time it is called.
If `assertEquals` is called anywhere in `testSum` with *unequal* inputs, the test fails.

Now notice that the first input to `assertEquals` is always a call to a method named "sum" in the class Lab1.
This implies that `testSum` is testing the Lab1 sum method.
Each time `assertEquals` is called, it checks the output of `sum`.
By looking at the inputs to `sum` and the second input to `assertEquals`, we can see that `sum` should add and then return its inputs (e.g., 2 + 2 is 4).

Each method in the Lab1Test class tests a different method in the Lab1 class.
By studying the tests, you can figure out how each Lab1 method should work.
Your job is to write the Lab1 methods so that they pass the tests.

This approach to writing software, where the tests are written *before* the code, is known as "test-driven development."
You will learn more about it later in the semester.

## Getting Started

The Lab1 class included in your GitHub repo is entirely empty other than the class declaration.
This is why the Lab1 methods are underlined in red in Lab1Tests.
(Lab1Tests can't find the methods in Lab1 because they don't exist yet.)

A good way to start this assignment is to add method stubs to Lab1.
A method stub consists of a method declaration and an arbitrary return value.
For instance, if you know a method returns an integer, the body of the stub could be `return 0;`.

For each test in Lab1Tests, try to write a stub for the Lab1 method being tested.
Think carefully about the method declarations.
In particular, ask yourself these questions:

* What is the data type of each input?
* What is the return type?
* Should the method be static?
* Should the method be public or private?

You'll know a stub is correct if the method is no longer underlined in Lab1Tests.
After you've written all the stubs, the project will run without warning you about errors.

This assignment is intended to be a review of concepts from your previous programming class, so consider looking back at your old code for help.
If you run into trouble, be sure to ask your TA some questions.

## Submit to zyLabs

After your code passes the unit tests, upload it to zyLabs to receive credit.
A link to zyLabs can be found on the Canvas page for this assignment.
