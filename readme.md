# CS 321 - Team 10

## Members
Matias Wiesbauer

Kevin Silvera

Haseeb Shuaib

Paul Brown

## Documentation

### Running the Program

You can run the program from the `src` directory with the following command.

`javac *.java ./entities/*.java ./managers/*.java ./coordinators/*.java`

`java FwClient ../test/job_sample-input.txt`


### JavaDoc

The JavaDoc documentation is stored in the `doc` directory. Use the `doc/index.html` file to view.

The following command will create JavaDoc Documentation and store the output in the `doc` directory.
Run the command from within the `src` directory.

`javadoc -d ../doc ./coordinators/*.java ./entities/*.java ./managers/*.java -author`


## Branching Setup
- Use a branch with your own name
    1. Update your local repository `git pull`
    2. Switch to development `git checkout development`
    3. Create a repo with your own name `git checkout -b YOURNAME`

- Merge your changes into the development branch at least daily
    1. Switch to the development branch `git checkout development`
    2. Merge your changes into development `git merge YOURNAME`

- If you would like to save changes from a branch to GitHub
    1. Add your changes to the repository `git add .`
    2. Commit your changes `git commit -m "DESCRIBE YOUR CHANGES"`
    3. Push to GitHub `git push origin BRANCHNAME`


![Branching Setup](/doc/branching.png?raw=true "Branching Setup")

## Testing
- Will be setup by Mathias

