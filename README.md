# Zendesk Ticket Viewer
*This project was implemented for Zendesk's Co-Op Coding Challenge*

The Zendesk Ticket Viewer is a CLI application that allows the user to view the tickets in their Zendesk account.

The ticket viewer should:
- [x] Connect to the Zendesk API
- [x] Request all the tickets for your account
- [x] Display them in a list
- [x] Display individual ticket details
- [ ] Page through tickets when more than 25 are returned

## Prerequisites
- Java installed on your machine

## Getting Started
1. clone git repo into a working directory of your choice
2. navigate to the working directory
3. navigate to "src" folder and modify code (specified to Sabrina) to add credentials
4. go back to previous directory - the main project folder (zendesk-ticket-viewer)
5. create a new folder named "out" in the working directory

## Compilation
In the working directory, compile the java program with this command:\
`javac -sourcepath src -d out -cp lib/json-20210307.jar src/Main.java`

## Execution
To run the compiled program execute this command:\
`java -cp out:lib/json-20210307.jar Main`
